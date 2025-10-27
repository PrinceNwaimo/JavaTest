package liangGraphs;

import java.util.*;

public class TestGraphPath {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}
        };

        List<AbstractGraph.Edge> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            edgeList.add(new AbstractGraph.Edge(e[0], e[1]));
            edgeList.add(new AbstractGraph.Edge(e[1], e[0])); // undirected
        }

        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edgeList, 6);

        List<Integer> path = graph.getPath(0, 5);

        System.out.println("Path from 0 to 5: " + path);
    }
}

