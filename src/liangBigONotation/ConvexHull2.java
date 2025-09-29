package liangBigONotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConvexHull2 {
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

        ArrayList<MyPoint> convexHull = getConvexHull(points);

        System.out.println("The points that form a convex hull are:");
        for (MyPoint point : convexHull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }

    public static ArrayList<MyPoint> getConvexHull(double[][] s) {
        MyPoint[] points = new MyPoint[s.length];
        for (int i = 0; i < s.length; i++) {
            points[i] = new MyPoint(s[i][0], s[i][1]);
        }

        MyPoint rightMostLowestPoint = getRightMostLowestPoint(points);
        for (MyPoint point : points) {
            point.setRightMostLowestPoint(rightMostLowestPoint);
        }

        Arrays.sort(points);

        ArrayList<MyPoint> convexHull = new ArrayList<>();
        convexHull.add(points[0]);
        convexHull.add(points[1]);

        for (int i = 2; i < points.length; i++) {
            while (convexHull.size() > 1 && whichSide(convexHull.get(convexHull.size() - 2), convexHull.get(convexHull.size() - 1), points[i]) <= 0) {
                convexHull.remove(convexHull.size() - 1);
            }
            convexHull.add(points[i]);
        }

        return convexHull;
    }

    private static MyPoint getRightMostLowestPoint(MyPoint[] points) {
        MyPoint rightMostLowestPoint = points[0];
        for (MyPoint point : points) {
            if (point.y < rightMostLowestPoint.y || (point.y == rightMostLowestPoint.y && point.x > rightMostLowestPoint.x)) {
                rightMostLowestPoint = point;
            }
        }
        return rightMostLowestPoint;
    }

    private static int whichSide(MyPoint p1, MyPoint p2, MyPoint p) {
        double result = (p2.x - p1.x) * (p.y - p1.y) - (p2.y - p1.y) * (p.x - p1.x);
        if (result > 0) {
            return 1; // Left side
        } else if (result < 0) {
            return -1; // Right side
        } else {
            return 0; // On the line
        }
    }

    private static class MyPoint implements Comparable<MyPoint> {
        double x, y;
        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void setRightMostLowestPoint(MyPoint p) {
            rightMostLowestPoint = p;
        }

        @Override
        public int compareTo(MyPoint o) {
            double dx1 = x - rightMostLowestPoint.x;
            double dy1 = y - rightMostLowestPoint.y;
            double dx2 = o.x - rightMostLowestPoint.x;
            double dy2 = o.y - rightMostLowestPoint.y;

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
    }
}
