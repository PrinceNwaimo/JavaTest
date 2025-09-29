package liangBigONotation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ConvexHullAnimation extends Application {
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Point> convexHull = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            if (e.isPrimaryButtonDown()) {
                points.add(new Point(e.getX(), e.getY()));
                updateConvexHull();
            } else if (e.isSecondaryButtonDown()) {
                removePoint(e.getX(), e.getY());
                updateConvexHull();
            }
            drawPointsAndConvexHull(pane);
        });

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Convex Hull Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateConvexHull() {
        convexHull.clear();
        if (points.size() < 3) {
            convexHull.addAll(points);
            return;
        }

        Point rightmostLowestPoint = getRightmostLowestPoint(points);
        convexHull.add(rightmostLowestPoint);
        Point currentPoint = rightmostLowestPoint;
        Point nextPoint = points.get(0);

        do {
            for (Point point : points) {
                if (point == currentPoint) {
                    continue;
                }
                if (nextPoint == currentPoint || whichSide(currentPoint, nextPoint, point) < 0) {
                    nextPoint = point;
                } else if (whichSide(currentPoint, nextPoint, point) == 0) {
                    if (distance(currentPoint, point) > distance(currentPoint, nextPoint)) {
                        nextPoint = point;
                    }
                }
            }
            convexHull.add(nextPoint);
            currentPoint = nextPoint;
            nextPoint = points.get(0);
        } while (nextPoint != rightmostLowestPoint);
    }

    private void drawPointsAndConvexHull(Pane pane) {
        pane.getChildren().clear();
        for (Point point : points) {
            Circle circle = new Circle(point.x, point.y, 3);
            circle.setFill(Color.BLACK);
            pane.getChildren().add(circle);
        }

        if (convexHull.size() > 1) {
            for (int i = 0; i < convexHull.size() - 1; i++) {
                Line line = new Line(convexHull.get(i).x, convexHull.get(i).y, convexHull.get(i + 1).x, convexHull.get(i + 1).y);
                pane.getChildren().add(line);
            }
            if (convexHull.size() > 2) {
                Line line = new Line(convexHull.get(convexHull.size() - 1).x, convexHull.get(convexHull.size() - 1).y, convexHull.get(0).x, convexHull.get(0).y);
                pane.getChildren().add(line);
            }
        }
    }

    private Point getRightmostLowestPoint(ArrayList<Point> points) {
        Point rightmostLowestPoint = points.get(0);
        for (Point point : points) {
            if (point.y < rightmostLowestPoint.y || (point.y == rightmostLowestPoint.y && point.x > rightmostLowestPoint.x)) {
                rightmostLowestPoint = point;
            }
        }
        return rightmostLowestPoint;
    }

    private int whichSide(Point p1, Point p2, Point p) {
        double result = (p2.x - p1.x) * (p.y - p1.y) - (p2.y - p1.y) * (p.x - p1.x);
        if (result > 0) {
            return 1; // Left side
        } else if (result < 0) {
            return -1; // Right side
        } else {
            return 0; // On the line
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
