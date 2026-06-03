package leetCodeProblems;
import java.util.*;

public class DirectedGraph implements Iterable<Vertex4>{
    private Map<Integer, Vertex4> vertDictionary;
    private int numVertices;

    public DirectedGraph() {
        this.vertDictionary = new HashMap<>();
        this.numVertices = 0;
    }

    @Override
    public Iterator<Vertex4> iterator() {
        return vertDictionary.values().iterator();
    }

    public Vertex4 addVertex(int node) {
        this.numVertices++;
        Vertex4 newVertex = new Vertex4(node);
        this.vertDictionary.put(node, newVertex);
        return newVertex;
    }

    public Vertex4 getVertex(int n) {
        return this.vertDictionary.getOrDefault(n, null);
    }

    public void addEdge(int frm, int to, int cost) {
        if (!vertDictionary.containsKey(frm)) {
            addVertex(frm);
        }
        if (!vertDictionary.containsKey(to)) {
            addVertex(to);
        }
        Vertex4 fromVertex = this.vertDictionary.get(frm);
        Vertex4 toVertex = this.vertDictionary.get(to);
        fromVertex.addNeighbor(toVertex, cost);
        // Kahn's algorithm: increase indegree of destination
        toVertex.setIndegree(toVertex.getIndegree() + 1);
    }

    public Set<Integer> getVertices() {
        return this.vertDictionary.keySet();
    }

    @Override
    public String toString() {
        return "Vertices: " + this.vertDictionary;
    }
}
