package liangMultiArrays;

import java.util.Scanner;

public class IntersectingPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[4][2];

        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4:");
        for (int i = 0; i < 4; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        double[] intersectingPoint = getIntersectingPoint(points);
        if (intersectingPoint == null) {
            System.out.println("The two lines are parallel");
        } else {
            System.out.println("The intersecting point is at (" + intersectingPoint[0] + ", " + intersectingPoint[1] + ")");
        }
    }

    public static double[] getIntersectingPoint(double[][] points) {
        double x1 = points[0][0];
        double y1 = points[0][1];
        double x2 = points[1][0];
        double y2 = points[1][1];
        double x3 = points[2][0];
        double y3 = points[2][1];
        double x4 = points[3][0];
        double y4 = points[3][1];

        double a = (y1 - y2);
        double b = -(x1 - x2);
        double c = (y3 - y4);
        double d = -(x3 - x4);
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;
        double f = (y3 - y4) * x3 - (x3 - x4) * y3;

        double determinant = a * d - b * c;
        if (determinant == 0) {
            return null;
        }

        double[] intersectingPoint = new double[2];
        intersectingPoint[0] = (e * d - b * f) / determinant;
        intersectingPoint[1] = (a * f - e * c) / determinant;
        return intersectingPoint;
    }

}
