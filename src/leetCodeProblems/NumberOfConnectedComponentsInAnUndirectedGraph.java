package leetCodeProblems;
import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) {
            return 1;
        }

        Graph graph = new Graph();
        for (int[] entry : edges) {
            graph.addEdge(entry[0], entry[1], 0);
        }

        int count = 0;
        for (Vertex vertex : graph) {
            if (vertex.getColor().equals("white")) {
                count++;
                bfs(graph, vertex);
            }
        }
        return count;
    }

    private void bfs(Graph graph, Vertex start) {
        start.setVisited();
        start.setColor("gray");
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Vertex neighbor : current.getConnections()) {
                if (neighbor.getColor().equals("white")) {
                    neighbor.setVisited();
                    neighbor.setColor("gray");
                    queue.offer(neighbor);
                }
            }
            current.setColor("black");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        NumberOfConnectedComponentsInAnUndirectedGraph solution = new NumberOfConnectedComponentsInAnUndirectedGraph();

        System.out.println(solution.countComponents(n, edges1)); // Output: 2
        System.out.println(solution.countComponents(n, edges2)); // Output: 1
    }
}
