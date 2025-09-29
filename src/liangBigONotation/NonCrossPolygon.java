package liangBigONotation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;


public class NonCrossPolygon extends Application {
    private static ArrayList<Point> points = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            if (e.isPrimaryButtonDown()) {
                points.add(new Point(e.getX(), e.getY()));
                Collections.sort(points);
                drawPointsAndPolygon(pane);
            } else if (e.isSecondaryButtonDown()) {
                removePoint(e.getX(), e.getY());
                drawPointsAndPolygon(pane);
            }
        });

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Non-Cross Polygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawPointsAndPolygon(Pane pane) {
        pane.getChildren().clear();
        for (Point point : points) {
            Circle circle = new Circle(point.x, point.y, 3);
            circle.setFill(Color.BLACK);
            pane.getChildren().add(circle);
        }

        if (points.size() > 1) {
            for (int i = 0; i < points.size() - 1; i++) {
                Line line = new Line(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
                pane.getChildren().add(line);
            }
            if (points.size() > 2) {
                Line line = new Line(points.get(points.size() - 1).x, points.get(points.size() - 1).y, points.get(0).x, points.get(0).y);
                pane.getChildren().add(line);
            }
        }
    }

    private void removePoint(double x, double y) {
        points.removeIf(point -> Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2)) < 5);
    }

    private static class Point implements Comparable<Point> {
        double x, y;
        static Point center;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (center == null) {
                center = getRightmostLowestPoint();
            }

            double dx1 = x - center.x;
            double dy1 = y - center.y;
            double dx2 = o.x - center.x;
            double dy2 = o.y - center.y;

            if (dx1 * dy2 - dx2 * dy1 > 0) {
                return -1;
            } else if (dx1 * dy2 - dx2 * dy1 < 0) {
                return 1;
            } else {
                if (dx1 * dx1 + dy1 * dy1 > dx2 * dx2 + dy2 * dy2) {
                    return -1;
                } else if (dx1 * dx1 + dy1 * dy1 < dx2 * dx2 + dy2 * dy2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        private Point getRightmostLowestPoint() {
            Point rightmostLowestPoint = points.get(0);
            for (Point point : points) {
                if (point.y < rightmostLowestPoint.y || (point.y == rightmostLowestPoint.y && point.x > rightmostLowestPoint.x)) {
                    rightmostLowestPoint = point;
                }
            }
            return rightmostLowestPoint;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
