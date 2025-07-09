package liangMultiArrays;

import java.util.Scanner;

public class RightmostLowestPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[6][2];

        System.out.println("Enter 6 points:");
        for (int i = 0; i < 6; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        double[] rightmostLowestPoint = getRightmostLowestPoint(points);
        System.out.println("The rightmost lowest point is (" + rightmostLowestPoint[0] + ", " + rightmostLowestPoint[1] + ")");
    }

    public static double[] getRightmostLowestPoint(double[][] points) {
        double[] rightmostLowestPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][1] < rightmostLowestPoint[1] || (points[i][1] == rightmostLowestPoint[1] && points[i][0] > rightmostLowestPoint[0])) {
                rightmostLowestPoint = points[i];
            }
        }
        return rightmostLowestPoint;
    }

}
