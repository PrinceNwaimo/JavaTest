
package liangWeighedGraphs;

import java.io.*;
import java.util.*;

public class FindMSTFromFile {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return;
        }

        Scanner fileScanner = new Scanner(file);

        // --- Step 1: Read number of vertices ---
        int numberOfVertices = Integer.parseInt(fileScanner.nextLine().trim());
        System.out.println("The number of vertices is " + numberOfVertices);

        // --- Step 2: Read edges ---
        List<WeightedEdge> edges = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            // Split by |
            String[] parts = line.split("\\|");
            for (String part : parts) {
                String[] values = part.trim().split(",");
                if (values.length < 3) continue;

                int u = Integer.parseInt(values[0].trim());
                int v = Integer.parseInt(values[1].trim());
                double w = Double.parseDouble(values[2].trim());

                // Since the graph is undirected, add both directions
                edges.add(new WeightedEdge(u, v, w));
                edges.add(new WeightedEdge(v, u, w));
            }
        }

        fileScanner.close();

        // --- Step 3: Create graph ---
        WeightedGraph2<Integer> graph = new WeightedGraph2<>();

        // --- Step 4: Display all weighted edges ---
        graph.printWeightedEdges();

        // --- Step 5: Get MST ---
        WeightedGraph2<Integer>.MST tree = graph.getMinimumSpanningTree();

        // --- Step 6: Display MST details ---
        System.out.println("Total weight in MST is " + tree.getTotalWeight());
        tree.printTree();
    }
}

