package chapterThree;

import java.util.Scanner;

public class PointInCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x-coordinate: ");
        double x = scanner.nextDouble();

        System.out.print("Enter y-coordinate: ");
        double y = scanner.nextDouble();

        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        if (distance <= 10) {
            System.out.println("(" + x + ", " + y + ") is inside the circle.");
        } else {
            System.out.println("(" + x + ", " + y + ") is outside the circle.");
        }
    }

}
