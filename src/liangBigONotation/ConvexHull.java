package liangBigONotation;

import java.awt.geom.Point2D;
import java.util.Scanner;
import java.util.ArrayList;



public class ConvexHull {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();
        double[][] points = new double[n][2];

        System.out.println("Enter the points:");
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        ArrayList<Point2D> convexHull = getConvexHull(points);

        System.out.println("The points that form a convex hull are:");
        for (Point2D point : convexHull) {
            System.out.println("(" + point.getX() + ", " + point.getY() + ")");
        }
    }

    public static ArrayList<Point2D> getConvexHull(double[][] s) {
        ArrayList<Point2D> points = new ArrayList<>();
        for (double[] point : s) {
            points.add(new Point2D() {
                @Override
                public double getX() {
                    return 0;
                }

                @Override
                public double getY() {
                    return 0;
                }

                @Override
                public void setLocation(double x, double y) {

                }
            });
        }

        ArrayList<Point2D> convexHull = new ArrayList<>();
        Point2D startPoint = getRightmostLowestPoint(points);
        convexHull.add(startPoint);
        Point2D currentPoint = startPoint;
        Point2D nextPoint = points.get(0);

        do {
            for (Point2D point : points) {
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
        } while (nextPoint != startPoint);

        return convexHull;
    }

    private static Point2D getRightmostLowestPoint(ArrayList<Point2D> points) {
        Point2D rightmostLowestPoint = points.get(0);
        for (Point2D point : points) {
            if (point.getY() < rightmostLowestPoint.getY() || (point.getY() == rightmostLowestPoint.getY() && point.getX() > rightmostLowestPoint.getX())) {
                rightmostLowestPoint = point;
            }
        }
        return rightmostLowestPoint;
    }

    private static int whichSide(Point2D p1, Point2D p2, Point2D p) {
        double result = (p2.getX() - p1.getX()) * (p.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p.getX() - p1.getX());
        if (result > 0) {
            return 1; // Left side
        } else if (result < 0) {
            return -1; // Right side
        } else {
            return 0; // On the line
        }
    }

    private static double distance(Point2D p1, Point2D p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
