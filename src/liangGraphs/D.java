package liangGraphs;

import javafx.scene.layout.Pane;

import java.util.List;

//public class GraphViewer extends Pane {
//    private AbstractGraph<?> graph;
//    private List<AbstractGraph.Edge> treeEdges;
//
//    public void setTree(List<AbstractGraph.Edge> tree) {
//        this.treeEdges = tree;
//        repaint();
//    }
//
//    private void repaint() {
//        getChildren().clear();
//        // draw all edges (gray)
//        for (int u = 0; u < graph.getSize(); u++) {
//            for (int v : graph.getNeighbors(u)) {
//                drawEdge(u, v, Color.GRAY);
//            }
//        }
//
//        // draw tree edges (red)
//        if (treeEdges != null) {
//            for (AbstractGraph.Edge e : treeEdges) {
//                drawEdge(e.u, e.v, Color.RED);
//            }
//        }
//
//        // draw vertices
//        for (int i = 0; i < graph.getSize(); i++) {
//            drawVertex(i);
//        }
//    }
//
//    // drawEdge() and drawVertex() same as Listing 28.6
//}

