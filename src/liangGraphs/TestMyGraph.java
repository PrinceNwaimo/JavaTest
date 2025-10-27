package liangGraphs;

import java.util.ArrayList;
import java.util.List;

public class TestMyGraph {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3},   // First component (0–3)
                {4, 5}                    // Second component (4–5)
        };

        List<AbstractGraph.Edge> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            edgeList.add(new AbstractGraph.Edge(e[0], e[1]));
        }

        MyGraph<Integer> graph = new MyGraph<>(edgeList, 6);
        List<List<Integer>> components = graph.getConnectedComponents();

        System.out.println("Connected components:");
        for (List<Integer> comp : components) {
            System.out.println(comp);
        }
    }
}
