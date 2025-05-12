package joyceUsingLoops;

import java.util.Scanner;

public class RetirementGoal2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int years = getValidInput(scanner, "Enter the number of years until retirement: ");
        double annualSavings = getValidSavings(scanner, "Enter the amount of money you can save annually: ");
        double interestRate = 0.04;

        double totalSavings = 0;
        for (int i = 1; i <= years; i++) {
            totalSavings = (totalSavings + annualSavings) * (1 + interestRate);
        }

        System.out.printf("You will have $%.2f at retirement.%n", totalSavings);

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
