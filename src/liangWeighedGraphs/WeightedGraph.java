package liangWeighedGraphs;

import liangGraphs.AbstractGraph4;

import java.util.*;

/**
 * WeightedGraph class that supports Kruskal’s algorithm for MST
 */
public class WeightedGraph<V> extends AbstractGraph4<V> {
    private List<WeightedEdge2> edges = new ArrayList<>();

    public WeightedGraph() { }

    public WeightedGraph(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V)(Integer)i);  // add vertices 0, 1, 2, ...
        for (int[] e : edges)
            addEdge(e[0], e[1], e[2]);
    }


    public WeightedGraph(String[] vertices, int[][] edges) {
        // Add all vertices first
        for (String vertex : vertices) {
            addVertex((V) vertex);
        }

        // Add all edges (u, v, weight)
        for (int[] edge : edges) {
            if (edge.length == 3) {
                addEdge(edge[0], edge[1], edge[2]);
            } else {
                throw new IllegalArgumentException("Each edge must have 3 values: [u, v, weight]");
            }
        }
    }

    public boolean addEdge(int u, int v, double weight) {
        WeightedEdge2 e1 = new WeightedEdge2(u, v, weight);
        WeightedEdge2 e2 = new WeightedEdge2(v, u, weight); // undirected

        // Ensure neighbors list has capacity
        while (neighbors.size() <= Math.max(u, v)) {
            neighbors.add(new ArrayList<>());
        }

        edges.add(e1);
        neighbors.get(u).add(e1);
        neighbors.get(v).add(e2);
        return true;
    }


    public List<WeightedEdge2> getEdges() {
        return edges;
    }

    public void printWeightedEdges() {
        for (WeightedEdge2 e : edges) {
            System.out.println("(" + getVertex(e.u) + " – " + getVertex(e.v) + ") weight: " + e.weight);
        }
    }

    /** Find MST using Kruskal’s algorithm */
    public MST getMinimumSpanningTreeKruskal() {
        // Step 1: Sort all edges by weight
        List<WeightedEdge2> sortedEdges = new ArrayList<>(edges);
        sortedEdges.sort(Comparator.comparingDouble(e -> e.weight));

        // Step 2: Create a parent map for union–find
        int[] parent = new int[getSize()];
        for (int i = 0; i < getSize(); i++)
            parent[i] = i;

        List<WeightedEdge2> treeEdges = new ArrayList<>();
        double totalWeight = 0;
        int edgeCount = 0;

        // Step 3: Iterate over edges
        for (WeightedEdge2 edge : sortedEdges) {
            int rootU = find(parent, edge.u);
            int rootV = find(parent, edge.v);

            // Only add edge if it doesn’t create a cycle
            if (rootU != rootV) {
                treeEdges.add(edge);
                totalWeight += edge.weight;
                edgeCount++;

                // Union the sets
                parent[rootV] = rootU;
            }

            // Stop when MST has (n - 1) edges
            if (edgeCount == getSize() - 1)
                break;
        }

        return new MST(0, parent, treeEdges, totalWeight);
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            parent[vertex] = find(parent, parent[vertex]); // path compression
        return parent[vertex];
    }

    /** Class for representing MST results */
    public class MST {
        private double totalWeight;
        private List<WeightedEdge2> treeEdges;

        public MST(int root, int[] parent, List<WeightedEdge2> edges, double totalWeight) {
            this.totalWeight = totalWeight;
            this.treeEdges = edges;
        }

        public double getTotalWeight() {
            return totalWeight;
        }

        public void printTree() {
            System.out.println("Edges in the MST:");
            for (WeightedEdge2 e : treeEdges)
                System.out.println("(" + getVertex(e.u) + " – " + getVertex(e.v) + ") weight: " + e.weight);
            System.out.println("Total weight: " + totalWeight);
        }
    }
}
