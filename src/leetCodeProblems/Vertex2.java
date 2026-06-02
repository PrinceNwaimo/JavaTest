package leetCodeProblems;
import java.util.*;

public class Vertex2 {
    int id;
    Map<Vertex2, Integer> adjacent;
    int indegree;
    int outdegree;
    Vertex2 predecessor;
    int visitTime;
    int finishTime;
    String color;

    public Vertex2(int key) {
        this.id = key;
        this.adjacent = new HashMap<>();
        this.indegree = 0;
        this.outdegree = 0;
        this.predecessor = null;
        this.visitTime = 0;
        this.finishTime = 0;
        this.color = "white";
    }

    public void addNeighbor(Vertex2 nbr, int weight) {
        adjacent.put(nbr, weight);
    }

    public Set<Vertex2> getNeighbors() {
        return adjacent.keySet();
    }

    public int getId() {
        return id;
    }

    public int getWeight(Vertex2 nbr) {
        return adjacent.get(nbr);
    }

    public int getIndegree() {
        return indegree;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }

    public int getOutdegree() {
        return outdegree;
    }

    public void setOutdegree(int outdegree) {
        this.outdegree = outdegree;
    }

    public Vertex2 getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex2 predecessor) {
        this.predecessor = predecessor;
    }

    public int getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(int visitTime) {
        this.visitTime = visitTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        List<Integer> adjIds = new ArrayList<>();
        for (Vertex2 v : adjacent.keySet()) {
            adjIds.add(v.id);
        }
        return id + " adjacent: " + adjIds;
    }
}
