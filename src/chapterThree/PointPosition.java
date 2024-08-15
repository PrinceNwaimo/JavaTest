package chapterThree;

import java.util.Scanner;

public class PointPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get coordinates for p0
        System.out.print("Enter x-coordinate for p0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Enter y-coordinate for p0: ");
        double y0 = scanner.nextDouble();

        // Get coordinates for p1
        System.out.print("Enter x-coordinate for p1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y-coordinate for p1: ");
        double y1 = scanner.nextDouble();

        // Get coordinates for p2
        System.out.print("Enter x-coordinate for p2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y-coordinate for p2: ");
        double y2 = scanner.nextDouble();

        // Calculate position value
        double positionValue = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        // Determine position of p2
        if (positionValue > 0) {
            System.out.println("p2 is on the left side of the line");
        } else if (positionValue == 0) {
            System.out.println("p2 is on the same line");
        } else {
            System.out.println("p2 is on the right side of the line");
        }
    }

}
