package liangGraphs;

import java.util.*;
import java.io.*;

/**
 * Reads a graph from a file and checks whether it is connected.
 */
public class GraphConnectedChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            UnweightedGraph<Integer> graph = readGraphFromFile(filename);
            System.out.println("\nEdges in the graph:");
            graph.printEdges();

            AbstractGraph.Tree tree = graph.dfs(0);
            int verticesFound = tree.getNumberOfVerticesFound();
            int numVertices = graph.getSize();

            System.out.println("\nNumber of vertices found: " + verticesFound);
            System.out.println("Total number of vertices: " + numVertices);

            if (verticesFound == numVertices) {
                System.out.println("✅ The graph is connected.");
            } else {
                System.out.println("❌ The graph is not connected.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    /** Reads a graph from a file in the format:
     *  numVertices
     *  u v1 v2 v3 ...
     *  u v1 v2 ...
     */
    public static UnweightedGraph<Integer> readGraphFromFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        int numVertices = fileScanner.nextInt();
        fileScanner.nextLine(); // consume end of line

        List<AbstractGraph.Edge> edges = new ArrayList<>();

        for (int u = 0; u < numVertices; u++) {
            if (!fileScanner.hasNextLine()) break;
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            int vertex = Integer.parseInt(parts[0]);

            for (int i = 1; i < parts.length; i++) {
                int v = Integer.parseInt(parts[i]);
                edges.add(new AbstractGraph.Edge(vertex, v));
            }
        }
        fileScanner.close();

        return new UnweightedGraph<>(edges, numVertices);
    }
}

/* ==============================================================
   AbstractGraph Class
   ============================================================== */
abstract class AbstractGraph2<V> {
    protected List<V> vertices = new ArrayList<>();
    protected List<List<Edge>> neighbors = new ArrayList<>();

    public AbstractGraph2() {}

    public AbstractGraph2(List<Edge> edges, int numVertices) {
        for (int i = 0; i < numVertices; i++) {
            vertices.add((V)(Integer)i);
            neighbors.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            neighbors.get(edge.u).add(edge);
        }
    }

    public int getSize() {
        return vertices.size();
    }

    public List<V> getVertices() {
        return vertices;
    }

    public List<Edge> getNeighbors(int v) {
        return neighbors.get(v);
    }

    public void printEdges() {
        for (int u = 0; u < neighbors.size(); u++) {
            System.out.print("Vertex " + u + ": ");
            for (Edge e : neighbors.get(u)) {
                System.out.print("(" + u + ", " + e.v + ") ");
            }
            System.out.println();
        }
    }

    /** Recursive DFS (default implementation) */
    public Tree dfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);
        boolean[] isVisited = new boolean[vertices.size()];
        dfs(v, parent, searchOrder, isVisited);
        return new Tree(v, parent, searchOrder);
    }

    private void dfs(int u, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
        isVisited[u] = true;
        searchOrder.add(u);
        for (Edge e : neighbors.get(u)) {
            int v = e.v;
            if (!isVisited[v]) {
                parent[v] = u;
                dfs(v, parent, searchOrder, isVisited);
            }
        }
    }

    /* ---------- Nested Helper Classes ---------- */

    public static class Edge {
        public int u, v;
        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static class Tree {
        private final int root;
        private final int[] parent;
        private final List<Integer> searchOrder;

        public Tree(int root, int[] parent, List<Integer> searchOrder) {
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }

        public int getNumberOfVerticesFound() {
            return searchOrder.size();
        }

        public List<Integer> getSearchOrder() {
            return searchOrder;
        }
    }
}

/* ==============================================================
   UnweightedGraph Class
   ============================================================== */
abstract class UnweightedGraph2<V> extends AbstractGraph<V> {
    public UnweightedGraph2(List<Edge> edges, int numVertices) {
        super(edges, numVertices);
    }

    @Override
    public void printEdges() {
        super.printEdges();
    }
}

