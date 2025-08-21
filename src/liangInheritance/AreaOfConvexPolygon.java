package liangInheritance;

import java.util.Scanner;

public class AreaOfConvexPolygon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the points: ");
        int n = scanner.nextInt();
        double[][] points = new double[n][2];
        System.out.println("Enter the coordinates of the points:");
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }
        double area = calculateArea(points);
        System.out.println("The total area is " + area);
    }

    public static double calculateArea(double[][] points) {
        double area = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += points[i][0] * points[j][1];
            area -= points[j][0] * points[i][1];
        }
        area = Math.abs(area) / 2;
        return area;
    }
}
