package liangGraphs;

import java.util.*;

public class MyGraph<V> extends UnweightedGraph<V> {

    public MyGraph(List<AbstractGraph.Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public MyGraph(int[][] edges1, int numberOfVertices) {
        super(edges1,numberOfVertices);
    }

    // --- MAIN METHOD REQUIRED BY THE QUESTION ---
    public List<List<Integer>> getConnectedComponents() {
        boolean[] visited = new boolean[getSize()];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < getSize(); i++) {
            if (!visited[i]) {
                // Perform DFS/BFS from vertex i
                List<Integer> component = new ArrayList<>();
                dfsComponent(i, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    // Helper method to perform DFS and fill one component
    private void dfsComponent(int v, boolean[] visited, List<Integer> component) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                component.add(current);

                // Visit all neighbors
                List<AbstractGraph.Edge> neighborsList = neighbors.get(current);
                for (AbstractGraph.Edge edge : neighborsList) {
                    if (!visited[edge.v]) {
                        stack.push(edge.v);
                    }
                }
            }
        }
    }
}

