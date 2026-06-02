package leetCodeProblems;

public class DFS {
    Graph2 graph;
    boolean hasCycle;

    public DFS(Graph2 graph) {
        this.graph = graph;
        this.hasCycle = false;
    }

    public void dfs() {
        for (Vertex2 vertex : graph.getAllVertices()) {
            if (vertex.getColor().equals("white")) {
                dfsVisit(vertex);
            }
        }
    }

    private void dfsVisit(Vertex2 vertex) {
        vertex.setColor("gray");
        for (Vertex2 neighbor : vertex.getNeighbors()) {
            if (neighbor.getColor().equals("white")) {
                dfsVisit(neighbor);
            } else if (neighbor.getColor().equals("gray")) {
                hasCycle = true;
            }
        }
        vertex.setColor("black");
    }
}
