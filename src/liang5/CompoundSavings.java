package liang5;

import java.util.Scanner;

    public class CompoundSavings {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt user for input
            System.out.print("Enter the monthly deposit amount: ");
            double monthlyDeposit = scanner.nextDouble();

            System.out.print("Enter the annual interest rate (in percentage): ");
            double annualInterestRate = scanner.nextDouble();

            System.out.print("Enter the number of months: ");
            int numberOfMonths = scanner.nextInt();

            // Calculate monthly interest rate
            double monthlyInterestRate = annualInterestRate / 100 / 12;

            // Initialize the savings account balance
            double accountBalance = 0.0;

            // Calculate the compound value over the number of months
            for (int month = 1; month <= numberOfMonths; month++) {
                accountBalance = (accountBalance + monthlyDeposit) * (1 + monthlyInterestRate);
            }

            // Display the final amount in the savings account
            System.out.printf("The amount in the savings account after %d months is: %.2f%n", numberOfMonths, accountBalance);
        }
    }

