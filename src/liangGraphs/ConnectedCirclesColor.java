package liangGraphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.*;

public class ConnectedCirclesColor extends Application {

    @Override
    public void start(Stage stage) {
        ConnectedCirclesPane pane = new ConnectedCirclesPane();

        Scene scene = new Scene(pane, 500, 350);
        stage.setTitle("Connected Circles in Different Colors");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /** Pane to draw and interact with circles */
    static class ConnectedCirclesPane extends Pane {
        private final List<Circle> circles = new ArrayList<>();
        private final double radius = 15;

        public ConnectedCirclesPane() {
            setOnMouseClicked(e -> {
                Circle newCircle = new Circle(e.getX(), e.getY(), radius);
                newCircle.setStroke(Color.BLACK);
                newCircle.setFill(Color.WHITE);

                if (!isOverlapping(newCircle)) {
                    circles.add(newCircle);
                    getChildren().add(newCircle);
                    colorConnectedComponents();
                }
            });
        }

        /** Checks if the circle overlaps with existing circles */
        private boolean isOverlapping(Circle newCircle) {
            for (Circle c : circles) {
                double dx = c.getCenterX() - newCircle.getCenterX();
                double dy = c.getCenterY() - newCircle.getCenterY();
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance <= 2 * radius) return true;
            }
            return false;
        }

        /** Detect connected components and color them */
        private void colorConnectedComponents() {
            // Step 1: Build adjacency list (graph)
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < circles.size(); i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < circles.size(); i++) {
                for (int j = i + 1; j < circles.size(); j++) {
                    if (areConnected(circles.get(i), circles.get(j))) {
                        adjList.get(i).add(j);
                        adjList.get(j).add(i);
                    }
                }
            }

            // Step 2: Find connected components using DFS
            boolean[] visited = new boolean[circles.size()];
            List<List<Integer>> components = new ArrayList<>();

            for (int i = 0; i < circles.size(); i++) {
                if (!visited[i]) {
                    List<Integer> component = new ArrayList<>();
                    dfs(i, visited, adjList, component);
                    components.add(component);
                }
            }

            // Step 3: Assign a random color to each component
            Random rand = new Random();
            for (List<Integer> component : components) {
                Color color = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
                for (int index : component) {
                    circles.get(index).setFill(color);
                }
            }
        }

        /** DFS traversal */
        private void dfs(int u, boolean[] visited, List<List<Integer>> adjList, List<Integer> component) {
            visited[u] = true;
            component.add(u);
            for (int v : adjList.get(u)) {
                if (!visited[v]) dfs(v, visited, adjList, component);
            }
        }

        /** Returns true if circles overlap or touch */
        private boolean areConnected(Circle c1, Circle c2) {
            double dx = c1.getCenterX() - c2.getCenterX();
            double dy = c1.getCenterY() - c2.getCenterY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            return distance <= 2 * radius;
        }
    }
}

