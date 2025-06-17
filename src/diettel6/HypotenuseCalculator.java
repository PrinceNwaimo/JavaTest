package diettel6;

import java.util.Scanner;

public class HypotenuseCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of side 1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side 2: ");
        double side2 = scanner.nextDouble();
        scanner.close();

        double hypotenuse = hypotenuse(side1, side2);
        System.out.printf("The length of the hypotenuse is: %.2f%n", hypotenuse);
    }

    public static double hypotenuse(double side1, double side2) {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }

}
