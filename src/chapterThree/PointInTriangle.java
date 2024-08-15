package chapterThree;

import java.util.Scanner;

public class PointInTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x-coordinate: ");
        double x = scanner.nextDouble();

        System.out.print("Enter y-coordinate: ");
        double y = scanner.nextDouble();

        if (x >= 0 && x <= 200 && y >= 0 && y <= 100 && x + y <= 200) {
            System.out.println("(" + x + ", " + y + ") is inside the triangle.");
        } else {
            System.out.println("(" + x + ", " + y + ") is outside the triangle.");
        }
    }

}
