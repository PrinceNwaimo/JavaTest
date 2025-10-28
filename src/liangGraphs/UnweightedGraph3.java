package liangGraphs;

import java.util.*;

public class UnweightedGraph3<V> extends  AbstractGraph4<V>{
    public UnweightedGraph3() {
    }
    /** Construct a graph from vertices and edges stored in arrays */
    public UnweightedGraph3(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }
    /** Construct a graph from vertices and edges stored in List */
    public UnweightedGraph3(List<V> vertices, List<AbstractGraph.Edge> edges) {
        super(vertices, edges);
    }
    public UnweightedGraph3(List<AbstractGraph.Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }
    /** Construct a graph from integer vertices 0, 1, and edge array */
    public UnweightedGraph3(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public List<Integer> getShortestPath(int start, int end) {
        boolean[] visited = new boolean[vertices.size()];
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) break;

            for (AbstractGraph4.Edge e : neighbors.get(current)) {
                int next = e.v;
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.offer(next);
                }
            }
        }

        // Reconstruct path
        if (!visited[end]) return null;

        List<Integer> path = new ArrayList<>();
        for (int v = end; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

}
