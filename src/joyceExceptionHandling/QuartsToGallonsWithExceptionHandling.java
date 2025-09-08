package joyceExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuartsToGallonsWithExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        double quarts = 0;

        while (!validInput) {
            try {
                System.out.print("Enter the number of quarts: ");
                quarts = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        double gallons = quarts / 4;
        System.out.println(quarts + " quarts is equal to " + gallons + " gallons.");
    }
}
