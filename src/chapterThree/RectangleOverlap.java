package chapterThree;

import java.util.Scanner;

public class RectangleOverlap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get first rectangle's coordinates and dimensions
        System.out.print("Enter center x-coordinate of first rectangle: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter center y-coordinate of first rectangle: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter width of first rectangle: ");
        double w1 = scanner.nextDouble();
        System.out.print("Enter height of first rectangle: ");
        double h1 = scanner.nextDouble();

        // Get second rectangle's coordinates and dimensions
        System.out.print("Enter center x-coordinate of second rectangle: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter center y-coordinate of second rectangle: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter width of second rectangle: ");
        double w2 = scanner.nextDouble();
        System.out.print("Enter height of second rectangle: ");
        double h2 = scanner.nextDouble();

        // Calculate distance between centers
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        // Check if second rectangle is inside first
        if (dx <= (w1 - w2) / 2 && dy <= (h1 - h2) / 2) {
            System.out.println("Second rectangle is inside first.");
        }
        // Check if second rectangle overlaps with first
        else if (dx <= (w1 + w2) / 2 && dy <= (h1 + h2) / 2) {
            System.out.println("Second rectangle overlaps with first.");
        } else {
            System.out.println("Second rectangle does not overlap with first.");
        }
    }

}
