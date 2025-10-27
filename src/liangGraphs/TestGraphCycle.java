package liangGraphs;

import java.util.*;

public class TestGraphCycle {
    public static void main(String[] args) {
        int[][] edgesWithCycle = {
                {0, 1}, {1, 2}, {2, 0},  // cycle (triangle)
                {3, 4}                   // disconnected part
        };

        int[][] edgesWithoutCycle = {
                {0, 1}, {1, 2}, {2, 3}
        };

        // Create graphs
        List<AbstractGraph.Edge> list1 = new ArrayList<>();
        for (int[] e : edgesWithCycle) {
            list1.add(new AbstractGraph.Edge(e[0], e[1]));
            list1.add(new AbstractGraph.Edge(e[1], e[0])); // undirected
        }

        List<AbstractGraph.Edge> list2 = new ArrayList<>();
        for (int[] e : edgesWithoutCycle) {
            list2.add(new AbstractGraph.Edge(e[0], e[1]));
            list2.add(new AbstractGraph.Edge(e[1], e[0]));
        }

        UnweightedGraph<Integer> graph1 = new UnweightedGraph<>(list1, 5);
        UnweightedGraph<Integer> graph2 = new UnweightedGraph<>(list2, 4);

        System.out.println("Graph 1 has cycle: " + graph1.isCyclic());
        System.out.println("Graph 2 has cycle: " + graph2.isCyclic());
    }
}

