package liangGraphs;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView3 extends Pane {
    private Graph3 graph;

    public GraphView3(Graph3 graph) {
        this.graph = graph;
        drawGraph();
    }

    private void drawGraph() {
        getChildren().clear();

        var vertices = graph.getVertices();
        var adjList = graph.getAdjList();

        // Draw edges
        for (int u = 0; u < adjList.size(); u++) {
            Graph3.Vertex vertexU = vertices.get(u);
            for (int v : adjList.get(u)) {
                Graph3.Vertex vertexV = vertices.get(v);

                Line line = new Line(vertexU.x, vertexU.y, vertexV.x, vertexV.y);
                line.setStroke(Color.GRAY);
                getChildren().add(line);
            }
        }

        // Draw vertices
        for (Graph3.Vertex vertex : vertices) {
            Circle circle = new Circle(vertex.x, vertex.y, 10);
            circle.setFill(Color.LIGHTBLUE);
            circle.setStroke(Color.BLACK);
            Text label = new Text(vertex.x - 4, vertex.y - 15, String.valueOf(vertex.id));
            getChildren().addAll(circle, label);
        }
    }
}

