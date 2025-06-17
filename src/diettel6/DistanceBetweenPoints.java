package diettel6;

import java.util.Scanner;

public class DistanceBetweenPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the x-coordinate of the first point: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the first point: ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter the x-coordinate of the second point: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second point: ");
        double y2 = scanner.nextDouble();

        scanner.close();

        double distance = distance(x1, y1, x2, y2);
        System.out.printf("The distance between the points (%f, %f) and (%f, %f) is: %f%n", x1, y1, x2, y2, distance);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
