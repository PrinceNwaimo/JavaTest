package liangGraphs;

import java.util.*;

public class Graph2 {
    private Map<Integer, Set<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new HashSet<>());
        adjList.putIfAbsent(v, new HashSet<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public Set<Integer> getNeighbors(int v) {
        return adjList.getOrDefault(v, new HashSet<>());
    }

    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    public int degree(int v) {
        return adjList.containsKey(v) ? adjList.get(v).size() : 0;
    }

    public void removeVertex(int v) {
        if (!adjList.containsKey(v)) return;
        for (int neighbor : new HashSet<>(adjList.get(v))) {
            adjList.get(neighbor).remove(v);
        }
        adjList.remove(v);
    }

    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    public static Graph2 maxInducedSubgraph(Graph2 g, int k) {
        Graph2 result = new Graph2();
        for (int v : g.getVertices()) {
            result.adjList.put(v, new HashSet<>(g.getNeighbors(v)));
        }

        boolean removed;
        do {
            removed = false;
            List<Integer> toRemove = new ArrayList<>();

            for (int v : new HashSet<>(result.getVertices())) {
                if (result.degree(v) < k) {
                    toRemove.add(v);
                }
            }

            if (!toRemove.isEmpty()) {
                removed = true;
                for (int v : toRemove) {
                    result.removeVertex(v);
                }
            }

        } while (removed);

        return result.isEmpty() ? null : result;
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.println(v + " -> " + adjList.get(v));
        }
    }

    public static void main(String[] args) {
        Graph2 g = new Graph2();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(0, 2);

        Graph2 sub = Graph2.maxInducedSubgraph(g, 2);
        if (sub == null) {
            System.out.println("No induced subgraph found with degree ≥ k");
        } else {
            sub.printGraph();
        }
    }
}

