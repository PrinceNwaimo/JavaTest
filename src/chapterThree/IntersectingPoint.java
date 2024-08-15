package chapterThree;

import java.util.Scanner;

public class IntersectingPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();

        System.out.print("Enter x4: ");
        double x4 = scanner.nextDouble();
        System.out.print("Enter y4: ");
        double y4 = scanner.nextDouble();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (denominator == 0) {
            System.out.println("The lines are parallel.");
        } else {
            double x = ((y1 - y2) * (x1 * x3 - x4 * x2) - (x1 - x2) * (y1 * x3 - y4 * x2)) / denominator;
            double y = ((x1 - x2) * (y1 * y3 - y4 * y2) - (y1 - y2) * (x1 * y3 - x4 * y2)) / denominator;

            System.out.println("The intersecting point is (" + x + ", " + y + ").");
        }
    }

}
