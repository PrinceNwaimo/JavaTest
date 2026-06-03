package leetCodeProblems;
import java.util.*;

public class Graph3 implements Iterable<Vertex3>{
    private Map<Integer, Vertex3> vertDictionary;
    private int numVertices;

    public Graph3() {
        this.vertDictionary = new HashMap<>();
        this.numVertices = 0;
    }

    @Override
    public Iterator<Vertex3> iterator() {
        return vertDictionary.values().iterator();
    }

    public Vertex3 addVertex(int node) {
        this.numVertices++;
        Vertex3 newVertex = new Vertex3(node);
        this.vertDictionary.put(node, newVertex);
        return newVertex;
    }

    public Vertex3 getVertex(int n) {
        return this.vertDictionary.getOrDefault(n, null);
    }

    public void addEdge(int frm, int to, int cost) {
        if (!vertDictionary.containsKey(frm)) {
            addVertex(frm);
        }
        if (!vertDictionary.containsKey(to)) {
            addVertex(to);
        }
        this.vertDictionary.get(frm).addNeighbor(this.vertDictionary.get(to), cost);
    }

    public Set<Integer> getVertices() {
        return this.vertDictionary.keySet();
    }

    @Override
    public String toString() {
        return "Vertices: " + this.vertDictionary;
    }
}
