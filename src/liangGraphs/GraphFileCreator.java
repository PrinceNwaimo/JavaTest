package liangGraphs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GraphFileCreator {
    public static void main(String[] args) {
        // Define edges based on the array in Listing 28.1
        int[][] edges = {
                {0, 1}, {0, 3}, {0, 5},
                {1, 0}, {1, 2}, {1, 3},
                {2, 1}, {2, 3}, {2, 4}, {2, 10},
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                {6, 5}, {6, 7},
                {7, 4}, {7, 5}, {7, 6}, {7, 8},
                {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                {9, 8}, {9, 11},
                {10, 2}, {10, 4}, {10, 8}, {10, 11},
                {11, 8}, {11, 9}, {11, 10}
        };

        int numVertices = 12; // Number of vertices

        try (PrintWriter writer = new PrintWriter(new FileWriter("graph1.txt"))) {
            writer.println(numVertices); // Write number of vertices on first line

            // Organize edges by vertex
            for (int i = 0; i < numVertices; i++) {
                writer.print(i);
                for (int[] edge : edges) {
                    if (edge[0] == i) {
                        writer.print(" " + edge[1]);
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Graph file 'graph1.txt' created.");
    }
}
