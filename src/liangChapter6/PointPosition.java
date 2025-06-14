package liangChapter6;

import java.util.Scanner;

public class PointPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three points for p0, p1, and p2: ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.close();

        if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
            System.out.printf("(%.1f, %.1f) is on the line segment from (%.1f, %.1f) to (%.1f, %.1f)%n", x2, y2, x0, y0, x1, y1);
        } else if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            System.out.printf("(%.1f, %.1f) is on the same line from (%.1f, %.1f) to (%.1f, %.1f)%n", x2, y2, x0, y0, x1, y1);
        } else if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.printf("(%.1f, %.1f) is on the left side of the line from (%.1f, %.1f) to (%.1f, %.1f)%n", x2, y2, x0, y0, x1, y1);
        } else {
            System.out.printf("(%.1f, %.1f) is on the right side of the line from (%.1f, %.1f) to (%.1f, %.1f)%n", x2, y2, x0, y0, x1, y1);
        }
    }

    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return Math.abs((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) < 1e-9;
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        return onTheSameLine(x0, y0, x1, y1, x2, y2)
                && (x2 - x0) * (x2 - x1) <= 0
                && (y2 - y0) * (y2 - y1) <= 0;
    }

}
