package leetCodeProblems;
import java.util.*;

public class Vertex4 {
    private int id;
    private Map<Vertex4, Integer> adjacent;
    private int distance;
    private boolean visited;
    private String color;
    private Vertex4 predecessor;
    private int indegree;

    public Vertex4(int node) {
        this.id = node;
        this.adjacent = new HashMap<>();
        this.distance = Integer.MAX_VALUE; // sys.maxsize
        this.visited = false;
        this.color = "white";
        this.predecessor = null;
        this.indegree = 0;
    }

    public void addNeighbor(Vertex4 neighbor, int weight) {
        this.adjacent.put(neighbor, weight);
    }

    public Set<Vertex4> getConnections() {
        return this.adjacent.keySet();
    }

    public int getVertexID() {
        return this.id;
    }

    public int getWeight(Vertex4 neighbor) {
        return this.adjacent.get(neighbor);
    }

    public void setDistance(int dist) {
        this.distance = dist;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setPrevious(Vertex4 prev) {
        this.predecessor = prev;
    }

    public Vertex4 getPrevious() {
        return this.predecessor;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }

    public int getIndegree() {
        return this.indegree;
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean getVisited() {
        return this.visited;
    }

    @Override
    public String toString() {
        List<Integer> adjIds = new ArrayList<>();
        for (Vertex4 v : adjacent.keySet()) {
            adjIds.add(v.id);
        }
        return this.id + " adjacent: " + adjIds;
    }
}
