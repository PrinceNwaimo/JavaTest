package liangBigONotation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;


import javafx.application.Application;

public class ClosestPairAnimation extends Application {
    private ArrayList<Point> points = new ArrayList<>();
    private Point[] closestPair = new Point[2];
    private double minDistance = Double.MAX_VALUE;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            if (e.isPrimaryButtonDown()) {
                points.add(new Point(e.getX(), e.getY()));
            } else if (e.isSecondaryButtonDown()) {
                removePoint(e.getX(), e.getY());
            }
            findClosestPair();
            drawPointsAndLine(pane);
        });

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Closest Pair Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void findClosestPair() {
        minDistance = Double.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double distance = distance(points.get(i), points.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = points.get(i);
                    closestPair[1] = points.get(j);
                }
            }
        }
    }

    private void drawPointsAndLine(Pane pane) {
        pane.getChildren().clear();
        for (Point point : points) {
            Circle circle = new Circle(point.x, point.y, 3);
            circle.setFill(Color.BLACK);
            pane.getChildren().add(circle);
        }
        if (closestPair[0] != null && closestPair[1] != null) {
            Line line = new Line(closestPair[0].x, closestPair[0].y, closestPair[1].x, closestPair[1].y);
            pane.getChildren().add(line);
        }
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    private void removePoint(double x, double y) {
        points.removeIf(point -> Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2)) < 5);
    }

    private static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
