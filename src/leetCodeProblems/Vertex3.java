package leetCodeProblems;
import java.util.*;

public class Vertex3 {
    private int id;
    private Map<Vertex3, Integer> adjacent;
    private int distance;
    private boolean visited;
    private String color;
    private Vertex3 previous;

    public Vertex3(int node) {
        this.id = node;
        this.adjacent = new HashMap<>();
        this.distance = Integer.MAX_VALUE; // sys.maxsize equivalent
        this.visited = false;
        this.color = "white";
        this.previous = null;
    }

    public void addNeighbor(Vertex3 neighbor, int weight) {
        this.adjacent.put(neighbor, weight);
    }

    public Set<Vertex3> getConnections() {
        return this.adjacent.keySet();
    }

    public int getVertexID() {
        return this.id;
    }

    public void setVisited() {
        this.visited = true;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDistance(int dist) {
        this.distance = dist;
    }

    public void setPrevious(Vertex3 prev) {
        this.previous = prev;
    }

    public Vertex3 getPrevious() {
        return this.previous;
    }

    @Override
    public String toString() {
        List<Integer> adjIds = new ArrayList<>();
        for (Vertex3 v : adjacent.keySet()) {
            adjIds.add(v.id);
        }
        return this.id + " adjacent: " + adjIds;
    }
}
