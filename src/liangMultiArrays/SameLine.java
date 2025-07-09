package liangMultiArrays;

import java.util.Scanner;

public class SameLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five points: ");
        double[][] points = new double[5][2];
        for (int i = 0; i < 5; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        if (sameLine(points)) {
            System.out.println("The five points are on the same line");
        } else {
            System.out.println("The five points are not on the same line");
        }
    }

    public static boolean sameLine(double[][] points) {
        for (int i = 0; i < points.length - 2; i++) {
            if (!onTheSameLine(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1], points[i + 2][0], points[i + 2][1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean onTheSameLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    }

}
