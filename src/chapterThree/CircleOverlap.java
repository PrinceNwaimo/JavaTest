package chapterThree;

import java.util.Scanner;

public class CircleOverlap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get first circle's coordinates and radius
        System.out.print("Enter center x-coordinate of first circle: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter center y-coordinate of first circle: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter radius of first circle: ");
        double r1 = scanner.nextDouble();

        // Get second circle's coordinates and radius
        System.out.print("Enter center x-coordinate of second circle: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter center y-coordinate of second circle: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter radius of second circle: ");
        double r2 = scanner.nextDouble();

        // Calculate distance between centers
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Check if second circle is inside first
        if (distance <= Math.abs(r1 - r2)) {
            System.out.println("Second circle is inside first.");
        }
        // Check if second circle overlaps with first
        else if (distance <= r1 + r2) {
            System.out.println("Second circle overlaps with first.");
        } else {
            System.out.println("Second circle does not overlap with first.");
        }
    }

}
