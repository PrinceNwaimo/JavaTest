package liangWeighedGraphs;

import java.util.*;

/**
 * Chapter 29.1 - Kruskal’s Algorithm for Minimum Spanning Tree (MST)
 *
 * This version follows the style and structure of Liang's examples:
 * - Uses WeightedEdge class
 * - Uses WeightedGraph class
 * - Returns a new MST as a WeightedGraph
 */
public class Kruskal {

    /**
     * Return a minimum spanning tree from a weighted graph
     */
    public static <V> WeightedGraph<V>.MST getMST(WeightedGraph<V> graph) {
        // Step 1: Create a priority queue for edges
        PriorityQueue<WeightedEdge2> edgeQueue =
                new PriorityQueue<>(graph.getEdges());

        int numberOfVertices = graph.getSize();
        int[] parent = new int[numberOfVertices];

        // Step 2: Initialize parent[i] = i
        for (int i = 0; i < numberOfVertices; i++)
            parent[i] = i;

        // Step 3: MST edges
        List<WeightedEdge2> mstEdges = new ArrayList<>();
        double totalWeight = 0;

        // Step 4: Keep adding edges until MST has (V - 1) edges
        while (mstEdges.size() < numberOfVertices - 1 && !edgeQueue.isEmpty()) {
            WeightedEdge2 edge = edgeQueue.poll();

            int uSet = find(parent, edge.u);
            int vSet = find(parent, edge.v);

            // If u and v are not yet connected, add this edge to the MST
            if (uSet != vSet) {
                parent[uSet] = vSet;
                mstEdges.add(edge);
                totalWeight += edge.weight;
            }
        }

        // Step 5: Return the MST result
        return graph.new MST(0, parent, mstEdges, totalWeight);
    }

    /** A helper method for finding the root parent of a vertex */
    private static int find(int[] parent, int vertex) {
        while (parent[vertex] != vertex)
            vertex = parent[vertex];
        return vertex;
    }

    // --- Test the algorithm ---
    public static void main(String[] args) {
        // Example based on Figure 29.1 in Liang
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges = {
                {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
                {1, 2, 381}, {1, 3, 1267},
                {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
                {3, 4, 599}, {3, 5, 1003},
                {4, 5, 533}, {4, 7, 1260}, {4, 8, 864}, {4, 10, 496},
                {5, 6, 983}, {5, 7, 787},
                {6, 7, 214}, {7, 8, 888},
                {8, 9, 661}, {8, 10, 781}, {8, 11, 810},
                {9, 11, 1187},
                {10, 11, 239}
        };

        WeightedGraph<String> graph = new WeightedGraph<>(vertices, edges);

        WeightedGraph<String>.MST mst = getMST(graph);
        System.out.println("Total weight of MST: " + mst.getTotalWeight());
        mst.printTree();
    }
}
