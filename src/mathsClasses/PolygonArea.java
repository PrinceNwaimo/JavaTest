package mathsClasses;

import java.util.Scanner;

public class PolygonArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of sides: ");
        int n = scanner.nextInt();

        System.out.print("Enter the side length: ");
        double s = scanner.nextDouble();

        double area = n * Math.pow(s, 2) / (4 * Math.tan(Math.PI / n));

        System.out.printf("The area of the polygon is: %.2f", area);
    }

}
