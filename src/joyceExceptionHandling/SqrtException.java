package joyceExceptionHandling;

import java.util.Scanner;

public class SqrtException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value: ");
        double value = scanner.nextDouble();

        try {
            double sqrt = calculateSquareRoot(value);
            System.out.println("The square root of " + value + " is " + sqrt);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double calculateSquareRoot(double value) {
        if (value < 0) {
            if (value < 0) {
                throw new ArithmeticException("Error: Cannot calculate square root of a negative number.");
            }
            return Math.sqrt(value);
        } else {
            return Math.sqrt(value);
        }
    }
}
