package leetCodeProblems;
import java.util.*;

public class Vertex {
    private int id;
    private Map<Vertex, Integer> adjacent;
    private int distance;
    private boolean visited;
    private String color;
    private Vertex previous;

    public Vertex(int node) {
        this.id = node;
        this.adjacent = new HashMap<>();
        this.distance = Integer.MAX_VALUE; // infinity
        this.visited = false;
        this.color = "white";
        this.previous = null;
    }

    public int getVertexID() {
        return id;
    }

    public Set<Vertex> getConnections() {
        return adjacent.keySet();
    }

    public Vertex getPrevious() {
        return previous;
    }

    public int getWeight(Vertex neighbor) {
        return adjacent.get(neighbor);
    }

    public void addNeighbor(Vertex neighbor, int weight) {
        adjacent.put(neighbor, weight);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrevious(Vertex prev) {
        this.previous = prev;
    }

    public void setVisited() {
        this.visited = true;
    }

    @Override
    public String toString() {
        List<Integer> adjIds = new ArrayList<>();
        for (Vertex v : adjacent.keySet()) {
            adjIds.add(v.id);
        }
        return id + " adjacent: " + adjIds;
    }
}
