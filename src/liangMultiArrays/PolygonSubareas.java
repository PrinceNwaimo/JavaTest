package liangMultiArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PolygonSubareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[4][2];

        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4:");
        for (int i = 0; i < 4; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        double[] areas = new double[4];

        // Calculate areas of four triangles
        areas[0] = getTriangleArea(new double[][]{points[0], points[1], points[2]});
        areas[1] = getTriangleArea(new double[][]{points[0], points[1], points[3]});
        areas[2] = getTriangleArea(new double[][]{points[0], points[2], points[3]});
        areas[3] = getTriangleArea(new double[][]{points[1], points[2], points[3]});

        Arrays.sort(areas);

        System.out.println("The areas of the triangles are:");
        for (double area : areas) {
            System.out.println(area);
        }
    }

    public static double getTriangleArea(double[][] points) {
        double x1 = points[0][0];
        double y1 = points[0][1];
        double x2 = points[1][0];
        double y2 = points[1][1];
        double x3 = points[2][0];
        double y3 = points[2][1];

        double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
        return area;
    }

}
