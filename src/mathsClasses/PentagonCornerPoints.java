package mathsClasses;

import java.util.Scanner;

public class PentagonCornerPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the bounding circle: ");
        double radius = scanner.nextDouble();

        double angleIncrement = 2 * Math.PI / 5;

        for (int i = 0; i < 5; i++) {
            double angle = i * angleIncrement;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            System.out.println("Point " + (i + 1) + ": (" + x + ", " + y + ")");
        }
    }

}
