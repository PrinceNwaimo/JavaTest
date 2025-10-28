package liangWeighedGraphs;

import liangGraphs.AbstractGraph;
import liangGraphs.AbstractGraph4;

import java.util.*;

/**
 * Fixed and cleaned WeightedGraph implementation.
 * - Uses an inner WeightedEdge2 class that extends AbstractGraph.Edge
 * - Supports undirected weighted graphs
 * - Implements addEdge, constructors, printing, getWeight, MST (Prim), shortest paths (Dijkstra-like)
 */
public class WeightedGraph2<V> extends AbstractGraph<V> {

    /**
     * Inner weighted edge class that extends AbstractGraph.Edge
     */
    public static class WeightedEdge2 extends AbstractGraph.Edge implements Comparable<WeightedEdge2> {
        public double weight;

        public WeightedEdge2(int u, int v, double weight) {
            super(u, v);
            this.weight = weight;
        }

        @Override
        public int compareTo(WeightedEdge2 o) {
            return Double.compare(this.weight, o.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof WeightedEdge2)) return false;
            WeightedEdge2 other = (WeightedEdge2) o;
            return this.u == other.u && this.v == other.v && Double.compare(this.weight, other.weight) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v, weight);
        }

        @Override
        public String toString() {
            return "(" + u + ", " + v + ", " + weight + ")";
        }
    }

    /* --------------------- Constructors --------------------- */

    /** Construct an empty WeightedGraph */
    public WeightedGraph2() {
        super();
    }

    /** Construct a WeightedGraph from vertices array and edges (int[][] with u,v,weight) */
    public WeightedGraph2(V[] vertices, int[][] edges) {
        List<V> vList = Arrays.asList(vertices);
        createWeightedGraph(vList, edges);
    }

    /** Construct a WeightedGraph from number of vertices and edge array (int[][] with u,v,weight) */
    public WeightedGraph2(int[][] edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            vertices.add((V) (Integer) i);
        }
        createWeightedGraph(vertices, edges);
    }

    /** Construct from a List of vertices and a list of WeightedEdge2 */
    public WeightedGraph2(List<V> vertices, List<WeightedEdge2> edges) {
        createWeightedGraph(vertices, edges);
    }

    /** Construct from weighted edge list and number of vertices */
    public WeightedGraph2(List<WeightedEdge2> edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            vertices.add((V) (Integer) i);
        }
        createWeightedGraph(vertices, edges);
    }

    /* --------------------- Graph creation helpers --------------------- */

    /** Create adjacency lists from edge arrays (int[][] where each row is {u, v, w}) */
    private void createWeightedGraph(List<V> vertices, int[][] edges) {
        this.vertices = vertices;
        neighbors = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            neighbors.add(new ArrayList<>()); // initialize neighbor list
        }

        for (int[] e : edges) {
            if (e.length < 3) continue; // skip malformed rows
            int u = e[0];
            int v = e[1];
            double w = e[2];
            addEdge(u, v, w); // uses addEdge to add both directions
        }
    }

    /** Create adjacency lists from an explicit list of WeightedEdge2 */
    private void createWeightedGraph(List<V> vertices, List<WeightedEdge2> edges) {
        this.vertices = vertices;
        neighbors = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            neighbors.add(new ArrayList<>());
        }
        for (WeightedEdge2 edge : edges) {
            addEdge(edge);
        }
    }

    /* --------------------- Edge operations --------------------- */

    /** Add an undirected weighted edge (u, v, weight) */
    public boolean addEdge(int u, int v, double weight) {
        return addEdge(new WeightedEdge2(u, v, weight));
    }

    /**
     * Add a WeightedEdge2 into the adjacency lists.
     * For an undirected graph, add both (u->v) and (v->u).
     */
    private boolean addEdge(WeightedEdge2 weightedEdge) {
        int u = weightedEdge.u;
        int v = weightedEdge.v;
        double w = weightedEdge.weight;

        // Validate indices
        if (u < 0 || u >= getSize() || v < 0 || v >= getSize()) {
            throw new IllegalArgumentException("No such index: " + u + " or " + v);
        }

        // Avoid duplicate edge in the same direction
        boolean added = false;

        // add u -> v
        boolean presentUV = false;
        for (Edge e : neighbors.get(u)) {
            if (e.v == v && e instanceof WeightedEdge2) {
                presentUV = true;
                break;
            }
        }
        if (!presentUV) {
            neighbors.get(u).add(new WeightedEdge2(u, v, w));
            added = true;
        }

        // add v -> u
        boolean presentVU = false;
        for (Edge e : neighbors.get(v)) {
            if (e.v == u && e instanceof WeightedEdge2) {
                presentVU = true;
                break;
            }
        }
        if (!presentVU) {
            neighbors.get(v).add(new WeightedEdge2(v, u, w));
            added = true;
        }

        return added;
    }

    /* --------------------- Utilities --------------------- */

    /** Return the weight on the edge (u, v) */
    public double getWeight(int u, int v) throws Exception {
        for (Edge edge : neighbors.get(u)) {
            if (edge.v == v) {
                return ((WeightedEdge2) edge).weight;
            }
        }
        throw new Exception("Edge does not exist: (" + u + ", " + v + ")");
    }

    /** Display edges with weights */
    public void printWeightedEdges() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(getVertex(i) + " (" + i + "): ");
            // print each neighbor only once? Here we print all adjacency entries
            for (Edge edge : neighbors.get(i)) {
                System.out.print("(" + edge.u + ", " + edge.v + ", " + ((WeightedEdge2) edge).weight + ") ");
            }
            System.out.println();
        }
    }

    /* --------------------- Minimum Spanning Tree (Prim) --------------------- */

    /** Get a minimum spanning tree rooted at vertex 0 */
    public MST getMinimumSpanningTree() {
        return getMinimumSpanningTree(0);
    }

    /** Get a minimum spanning tree rooted at a specified vertex using Prim's algorithm */
    public MST getMinimumSpanningTree(int startingVertex) {
        int n = getSize();
        // cost[v] stores the cost of adding v to the tree
        double[] cost = new double[n];
        Arrays.fill(cost, Double.POSITIVE_INFINITY);
        cost[startingVertex] = 0;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        double totalWeight = 0;
        List<Integer> T = new ArrayList<>();

        while (T.size() < n) {
            // Find smallest cost vertex in V - T
            int u = -1;
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < n; i++) {
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            if (u == -1) break; // disconnected graph

            T.add(u);
            totalWeight += cost[u];

            // Update neighbors
            for (Edge e : neighbors.get(u)) {
                int v = e.v;
                if (!T.contains(v) && cost[v] > ((WeightedEdge2) e).weight) {
                    cost[v] = ((WeightedEdge2) e).weight;
                    parent[v] = u;
                }
            }
        }

        return new MST(startingVertex, parent, T, totalWeight);
    }

    /** MST is an inner class in WeightedGraph */
    public class MST extends Tree {
        private final double totalWeight;

        public MST(int root, int[] parent, List<Integer> searchOrder, double totalWeight) {
            super(root, searchOrder);
            this.totalWeight = totalWeight;
        }

        public double getTotalWeight() {
            return totalWeight;
        }
    }

    /* --------------------- Single-Source Shortest Paths (Dijkstra-like, using arrays) --------------------- */

    /** Find single source shortest paths (Dijkstra-like simple O(n^2) implementation) */
    public ShortestPathTree getShortestPath(int sourceVertex) {
        int n = getSize();
        double[] cost = new double[n];
        Arrays.fill(cost, Double.POSITIVE_INFINITY);
        cost[sourceVertex] = 0;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        List<Integer> T = new ArrayList<>();

        while (T.size() < n) {
            int u = -1;
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < n; i++) {
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            if (u == -1) break; // remaining vertices unreachable
            T.add(u);

            for (Edge e : neighbors.get(u)) {
                int v = e.v;
                double w = ((WeightedEdge2) e).weight;
                if (!T.contains(v) && cost[v] > cost[u] + w) {
                    cost[v] = cost[u] + w;
                    parent[v] = u;
                }
            }
        }

        return new ShortestPathTree(sourceVertex, parent, T, cost);
    }

    /** ShortestPathTree is an inner class in WeightedGraph */
    public class ShortestPathTree extends Tree {
        private final double[] cost;

        /** Construct a path */
        public ShortestPathTree(int source, int[] parent, List<Integer> searchOrder, double[] cost) {
            super(source, searchOrder);
            this.cost = cost;
        }

        /** Return the cost for a path from the root to vertex v */
        public double getCost(int v) {
            return cost[v];
        }

        /** Print paths from all vertices to the source */
        public void printAllPaths() {
            System.out.println("All shortest paths from " + vertices.get(getRoot()) + " are:");
            for (int i = 0; i < cost.length; i++) {
                printPath(i);
                System.out.println("(cost: " + cost[i] + ")");
            }
        }
    }
}
