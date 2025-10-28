package liangWeighedGraphs;

import java.util.Arrays;

public class PrimMSTWithAdjacencyMatrix {

    /**
     * Compute Minimum Spanning Tree (MST) using Prim’s Algorithm
     * with an adjacency matrix representation.
     *
     * @param graph the adjacency matrix (graph[u][v] = weight or 0 if no edge)
     * @return array of parent vertices that represent the MST
     */
    public static int[] primMST(double[][] graph) {
        int numberOfVertices = graph.length;

        // parent[i] will store the parent vertex in MST
        int[] parent = new int[numberOfVertices];

        // key[i] keeps track of minimum weight edge to include vertex i
        double[] key = new double[numberOfVertices];

        // mstSet[i] is true if vertex i is already included in MST
        boolean[] mstSet = new boolean[numberOfVertices];

        // Initialize all keys as infinite
        Arrays.fill(key, Double.POSITIVE_INFINITY);

        // Always start with vertex 0 as root
        key[0] = 0.0;
        parent[0] = -1; // root has no parent

        // Build MST with (V - 1) edges
        for (int count = 0; count < numberOfVertices - 1; count++) {
            // Pick the vertex with the minimum key value not in MST
            int u = minKeyVertex(key, mstSet, numberOfVertices);
            mstSet[u] = true; // Include u in MST

            // Update key and parent for adjacent vertices of u
            for (int v = 0; v < numberOfVertices; v++) {
                double weight = graph[u][v];
                if (weight != 0 && !mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        // Return MST parent array
        return parent;
    }

    /**
     * Find the vertex with the minimum key value that’s not yet included in MST
     */
    private static int minKeyVertex(double[] key, boolean[] mstSet, int n) {
        double min = Double.POSITIVE_INFINITY;
        int minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * Utility method to print the MST and total weight
     */
    public static void printMST(int[] parent, double[][] graph) {
        double totalWeight = 0;
        System.out.println("Edge \tWeight");

        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }

    // Demo
    public static void main(String[] args) {
        double[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        int[] parent = primMST(graph);
        printMST(parent, graph);
    }
}

