package liangGraphs;

import java.util.*;

public abstract class UnweightedGraph <V> extends  AbstractGraph<V> {
    /** Construct an empty graph */
  public UnweightedGraph() {
            }
    /** Construct a graph from vertices and edges stored in arrays */
    public UnweightedGraph(V[] vertices, int[][] edges) {
         super(vertices, edges);
            }
          /** Construct a graph from vertices and edges stored in List */
          public UnweightedGraph(List<V> vertices, List<Edge> edges) {
         super(vertices, edges);
            }
    public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
            }
    /** Construct a graph from integer vertices 0, 1, and edge array */
    public UnweightedGraph(int[][] edges, int numberOfVertices) {
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

            for (Edge e : neighbors.get(current)) {
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
