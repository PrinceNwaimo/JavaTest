package joyceUsingLoops;

import java.util.Scanner;

public class RetirementGoal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int years = getValidInput(scanner, "Enter the number of years until retirement: ");
        double annualSavings = getValidSavings(scanner, "Enter the amount of money you can save annually: ");

        double totalSavings = years * annualSavings;

        System.out.println("You will have $" + totalSavings + " at retirement.");

        scanner.close();
    }

    public static int getValidInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            int input = scanner.nextInt();
            if (input > 0) {
                return input;
            }
            System.out.println("Please enter a positive number.");
        }
    }

    public static double getValidSavings(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            double input = scanner.nextDouble();
            if (input > 0) {
                return input;
            }
            System.out.println("Please enter a positive number.");
        }
    }

}
