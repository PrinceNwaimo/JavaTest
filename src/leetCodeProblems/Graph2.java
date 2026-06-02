package leetCodeProblems;
import java.util.*;

public class Graph2 {
    Map<Integer, Vertex2> vertexDict;
    int noVertices;
    int noEdges;

    public Graph2() {
        vertexDict = new HashMap<>();
        noVertices = 0;
        noEdges = 0;
    }

    public void addVertex(int vertKey) {
        Vertex2 newVertex = new Vertex2(vertKey);
        vertexDict.put(vertKey, newVertex);
        noVertices++;
    }

    public Vertex2 getVertex(int vertKey) {
        return vertexDict.getOrDefault(vertKey, null);
    }

    public void addEdge(int fromVert, int toVert, int weight) {
        if (!vertexDict.containsKey(fromVert)) {
            addVertex(fromVert);
        }
        if (!vertexDict.containsKey(toVert)) {
            addVertex(toVert);
        }
        vertexDict.get(fromVert).addNeighbor(vertexDict.get(toVert), weight);
        noEdges++;
    }

    public List<int[]> getEdges() {
        List<int[]> edges = new ArrayList<>();
        for (Vertex2 vertex : vertexDict.values()) {
            for (Vertex2 neighbor : vertex.getNeighbors()) {
                edges.add(new int[]{vertex.getId(), neighbor.getId()});
            }
        }
        return edges;
    }

    public Set<Integer> getVertices() {
        return vertexDict.keySet();
    }

    public Collection<Vertex2> getAllVertices() {
        return vertexDict.values();
    }
}
