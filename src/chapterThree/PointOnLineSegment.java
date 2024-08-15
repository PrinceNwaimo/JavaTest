package chapterThree;

import java.util.Scanner;

public class PointOnLineSegment {
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

        // Check if p2 is on the line
        if (positionValue == 0) {
            // Check if p2 is within the line segment
            if ((x0 <= x2 && x2 <= x1) || (x1 <= x2 && x2 <= x0)) {
                if ((y0 <= y2 && y2 <= y1) || (y1 <= y2 && y2 <= y0)) {
                    System.out.println("p2 is on the line segment");
                } else {
                    System.out.println("p2 is not on the line segment");
                }
            } else {
                System.out.println("p2 is not on the line segment");
            }
        } else {
            System.out.println("p2 is not on the line");
        }
    }

}
