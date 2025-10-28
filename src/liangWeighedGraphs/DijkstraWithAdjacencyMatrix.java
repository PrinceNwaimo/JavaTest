package liangWeighedGraphs;

import java.util.Arrays;

public class DijkstraWithAdjacencyMatrix {

    /**
     * Compute shortest paths from a given source vertex
     * using Dijkstra’s algorithm on an adjacency matrix.
     *
     * @param graph  adjacency matrix (graph[u][v] = weight, or 0 if no edge)
     * @param source source vertex index
     * @return array of parent vertices representing shortest paths
     */
    public static int[] dijkstra(double[][] graph, int source) {
        int n = graph.length;

        // shortestDist[i] will hold the shortest distance from source to i
        double[] shortestDist = new double[n];
        Arrays.fill(shortestDist, Double.POSITIVE_INFINITY);
        shortestDist[source] = 0.0;

        // parent[i] holds the vertex from which we reached i
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // visited[i] true if vertex i is already processed
        boolean[] visited = new boolean[n];

        // Find shortest path for all vertices
        for (int count = 0; count < n - 1; count++) {
            // Pick vertex u with minimum distance not yet visited
            int u = minDistanceVertex(shortestDist, visited);
            visited[u] = true;

            // Update distance of adjacent vertices of u
            for (int v = 0; v < n; v++) {
                double weight = graph[u][v];
                if (weight > 0 && !visited[v] &&
                        shortestDist[u] + weight < shortestDist[v]) {
                    shortestDist[v] = shortestDist[u] + weight;
                    parent[v] = u;
                }
            }
        }

        // Print results
        printSolution(source, shortestDist, parent);

        return parent;
    }

    /**
     * Utility method to find vertex with the minimum distance
     * value not yet included in shortest path tree.
     */
    private static int minDistanceVertex(double[] dist, boolean[] visited) {
        double min = Double.POSITIVE_INFINITY;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * Print shortest distance results
     */
    private static void printSolution(int src, double[] dist, int[] parent) {
        System.out.println("Vertex\t\tDistance from Source\tPath");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(src + " -> " + i + "\t\t" + dist[i] + "\t\t");
            printPath(i, parent);
            System.out.println();
        }
    }

    /**
     * Recursively print path from source to vertex
     */
    private static void printPath(int vertex, int[] parent) {
        if (vertex == -1) return;
        printPath(parent[vertex], parent);
        System.out.print(vertex + " ");
    }

    // Demo
    public static void main(String[] args) {
        double[][] graph = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };

        int source = 0;
        dijkstra(graph, source);
    }
}

