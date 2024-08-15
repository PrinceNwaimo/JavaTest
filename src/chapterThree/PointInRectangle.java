package chapterThree;

import java.util.Scanner;

public class PointInRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x-coordinate: ");
        double x = scanner.nextDouble();

        System.out.print("Enter y-coordinate: ");
        double y = scanner.nextDouble();

        double horizontalDistance = Math.abs(x);
        double verticalDistance = Math.abs(y);

        if (horizontalDistance <= 10 / 2 && verticalDistance <= 5 / 2) {
            System.out.println("(" + x + ", " + y + ") is inside the rectangle.");
        } else {
            System.out.println("(" + x + ", " + y + ") is outside the rectangle.");
        }
    }

}
