package liangCollections;

import java.util.Arrays;
import java.util.Random;

public class PointTest {
    public static void main(String[] args) {
        Point[] points = new Point[100];
        Random random = new Random();

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(random.nextDouble() * 100, random.nextDouble() * 100);
        }

        System.out.println("Original points:");
        printPoints(points);

        Arrays.sort(points);
        System.out.println("\nPoints sorted by x-coordinates:");
        printPoints(points);

        Arrays.sort(points, new CompareY());
        System.out.println("\nPoints sorted by y-coordinates:");
        printPoints(points);
    }

    private static void printPoints(Point[] points) {
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
