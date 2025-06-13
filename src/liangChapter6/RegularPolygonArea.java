package liangChapter6;

import java.util.Scanner;

public class RegularPolygonArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int n = scanner.nextInt();
        System.out.print("Enter the side: ");
        double side = scanner.nextDouble();
        scanner.close();

        double area = area(n, side);
        System.out.println("The area of the polygon is " + area);
    }

    public static double area(int n, double side) {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }

}
