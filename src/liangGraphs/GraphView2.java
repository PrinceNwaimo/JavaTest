package liangGraphs;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.List;

public class GraphView2 extends Pane {
    private Graph<? extends Displayable2> graph;
    private AbstractGraph4.Tree tree; // ✅ new field for DFS/BFS tree

    public GraphView2(Graph<? extends Displayable2> graph) {
        this.graph = graph;
        repaintGraph();
    }

    /** ✅ Setter for tree */
    public void setTree(AbstractGraph4.Tree tree) {
        this.tree = tree;
        repaintGraph();
    }

    /** ✅ Repaint the graph (and tree edges if available) */
    private void repaintGraph() {
        getChildren().clear();

        // Draw vertices
        List<? extends Displayable2> vertices = graph.getVertices();
        for (Displayable2 v : vertices) {
            getChildren().addAll(
                    new Text(v.getX() - 8, v.getY() - 8, v.getName())
            );
        }

        // Draw edges (default color = black)
        for (int i = 0; i < graph.getSize(); i++) {
            for (int neighbor : graph.getNeighbors(i)) {
                Displayable2 u = vertices.get(i);
                Displayable2 v = vertices.get(neighbor);
                Line line = new Line(u.getX(), u.getY(), v.getX(), v.getY());
                line.setStroke(Color.BLACK);
                getChildren().add(line);
            }
        }

        // Draw DFS/BFS tree edges (red)
        if (tree != null) {
            for (int i = 0; i < graph.getSize(); i++) {
                int parent = tree.getParent(i);
                if (parent != -1) {
                    Displayable2 u = vertices.get(i);
                    Displayable2 v = vertices.get(parent);
                    Line line = new Line(u.getX(), u.getY(), v.getX(), v.getY());
                    line.setStroke(Color.RED);
                    line.setStrokeWidth(2.5);
                    getChildren().add(line);
                }
            }
        }
    }
}
