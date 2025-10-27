package liangGraphs;

import liangGraphs.AbstractGraph;
import liangGraphs.UnweightedGraph;

import java.io.*;
import java.util.*;

public class GraphShortestPath {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the graph file name: ");
        String filename = input.nextLine();

        // Read graph
        UnweightedGraph<Integer> graph = readGraphFromFile(filename);

        System.out.print("Enter the start vertex: ");
        int u = input.nextInt();

        System.out.print("Enter the end vertex: ");
        int v = input.nextInt();

        List<Integer> path = graph.getShortestPath(u, v);

        if (path != null) {
            System.out.println("Shortest path from " + u + " to " + v + ": " + path);
        } else {
            System.out.println("No path found between " + u + " and " + v);
        }
    }

    // Read a graph from file
    public static UnweightedGraph<Integer> readGraphFromFile(String filename) throws IOException {
        Scanner file = new Scanner(new File(filename));
        int numberOfVertices = file.nextInt();
        file.nextLine();

        List<AbstractGraph.Edge> edges = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            String line = file.nextLine();
            String[] tokens = line.split("\\s+");
            int u = Integer.parseInt(tokens[0]);
            for (int j = 1; j < tokens.length; j++) {
                int v = Integer.parseInt(tokens[j]);
                edges.add(new AbstractGraph.Edge(u, v));
            }
        }
        file.close();

        return new UnweightedGraph<>(edges, numberOfVertices);
    }
}

