package liangChapter6;

import java.util.Scanner;

public class PentagonArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the side: ");
        double side = scanner.nextDouble();
        scanner.close();

        double area = area(side);
        System.out.println("The area of the pentagon is " + area);
    }

    public static double area(double side) {
        return (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

}
