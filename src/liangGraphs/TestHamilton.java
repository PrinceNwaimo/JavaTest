package liangGraphs;

import java.util.List;

public class TestHamilton {
    public static void main(String[] args) {
        UnweightedGraph<String> graph = new UnweightedGraph<>(
                new String[]{"A", "B", "C", "D"},
                new int[][] {
                        {0, 1}, {1, 2}, {2, 3}, {3, 0}
                }
        );

        List<Integer> cycle = graph.getHamiltonianCycle();
        if (cycle != null) {
            System.out.println("Hamiltonian Cycle: " + cycle);
        } else {
            System.out.println("No Hamiltonian cycle found.");
        }
    }

}
