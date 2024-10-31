package liang5;

import java.util.Scanner;

public class CDValueCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the initial amount (e.g., 10000): ");
        double initialAmount = scanner.nextDouble();

        System.out.print("Enter the annual percentage yield (e.g., 5.75): ");
        double annualPercentageYield = scanner.nextDouble();

        System.out.print("Enter the number of months (e.g., 18): ");
        int numberOfMonths = scanner.nextInt();

        // Calculate monthly interest rate
        double monthlyInterestRate = annualPercentageYield / 1200; // Divide by 1200 to get the monthly rate

        // Initialize the current CD value
        double currentCDValue = initialAmount;

        // Print the header for the table
        System.out.printf("%-10s%-15s%n", "Month", "CD Value");
        System.out.println("-----------------------------");

        // Calculate and display the CD value for each month
        for (int month = 1; month <= numberOfMonths; month++) {
            currentCDValue += currentCDValue * monthlyInterestRate; // Update the current CD value
            System.out.printf("%-10d%-15.2f%n", month, currentCDValue); // Display month and current CD value
        }
    }
}

