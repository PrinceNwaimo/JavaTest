package liangGraphs;

import java.util.*;

public class Graph3 {
    protected List<Vertex> vertices = new ArrayList<>();
    protected List<List<Integer>> adjList = new ArrayList<>();

    public static class Vertex {
        int id;
        double x, y;

        public Vertex(int id, double x, double y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
        adjList.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        if (!adjList.get(u).contains(v)) {
            adjList.get(u).add(v);
        }
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}

