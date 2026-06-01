package leetCodeProblems;
import java.util.*;

public class Graph implements Iterable<Vertex>{
    private final Map<Integer, Vertex> vertDictionary;
    private int numVertices;

    public Graph() {
        vertDictionary = new HashMap<>();
        numVertices = 0;
    }

    @Override
    public Iterator<Vertex> iterator() {
        return vertDictionary.values().iterator();
    }

    public Vertex addVertex(int node) {
        numVertices++;
        Vertex newVertex = new Vertex(node);
        vertDictionary.put(node, newVertex);
        return newVertex;
    }

    public Vertex getVertex(int n) {
        return vertDictionary.getOrDefault(n, null);
    }

    public void addEdge(int frm, int to, int cost) {
        if (!vertDictionary.containsKey(frm)) {
            addVertex(frm);
        }
        if (!vertDictionary.containsKey(to)) {
            addVertex(to);
        }

        Vertex frmVertex = vertDictionary.get(frm);
        Vertex toVertex = vertDictionary.get(to);

        frmVertex.addNeighbor(toVertex, cost);
        toVertex.addNeighbor(frmVertex, cost); // undirected
    }

    public Set<Integer> getVertices() {
        return vertDictionary.keySet();
    }

    public void setPrevious(int current, Vertex prev) {
        vertDictionary.get(current).setPrevious(prev);
    }

    public Vertex getPrevious(int current) {
        return vertDictionary.get(current).getPrevious();
    }
}
