package liangChapter9;

import java.util.Scanner;

public class PointTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the endpoints of the first line segment (x1, y1, x2, y2): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.print("Enter the endpoints of the second line segment (x3, y3, x4, y4): ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();

        Point intersection = getIntersectingPoint(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4));

        if (intersection != null) {
            System.out.println("The intersecting point is: (" + intersection.x + ", " + intersection.y + ")");
        } else {
            System.out.println("The two line segments do not intersect.");
        }
    }

    public static Point getIntersectingPoint(Point p1, Point p2, Point p3, Point p4) {
        LinearEquation equation1 = getLinearEquation(p1, p2);
        LinearEquation equation2 = getLinearEquation(p3, p4);

        if (equation1 == null || equation2 == null) {
            return null;
        }

        if (!equation1.isSolvable()) {
            return null;
        }

        double x = equation1.getX();
        double y = equation1.getY();

        if (isPointOnLineSegment(p1, p2, x, y) && isPointOnLineSegment(p3, p4, x, y)) {
            return new Point(x, y);
        } else {
            return null;
        }
    }

    public static LinearEquation getLinearEquation(Point p1, Point p2) {
        if (p2.x - p1.x == 0) {
            return null; // vertical line
        }

        double a = -(p2.y - p1.y) / (p2.x - p1.x);
        double b = 1;
        double e = a * p1.x - p1.y;

        return new LinearEquation(a, b, e);
    }

    public static boolean isPointOnLineSegment(Point p1, Point p2, double x, double y) {
        return (Math.min(p1.x, p2.x) <= x && x <= Math.max(p1.x, p2.x)) &&
                (Math.min(p1.y, p2.y) <= y && y <= Math.max(p1.y, p2.y));
    }
}
