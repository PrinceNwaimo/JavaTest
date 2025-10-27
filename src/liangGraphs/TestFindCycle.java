package liangGraphs;

import java.util.*;

public class TestFindCycle {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0},  // cycle
                {3, 4}                   // no cycle here
        };

        List<AbstractGraph.Edge> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            edgeList.add(new AbstractGraph.Edge(e[0], e[1]));
            edgeList.add(new AbstractGraph.Edge(e[1], e[0])); // undirected
        }

        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edgeList, 5);

        List<Integer> cycle = graph.getACycle(0);
        if (cycle != null) {
            System.out.println("Cycle found: " + cycle);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
