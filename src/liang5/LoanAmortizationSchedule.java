package liang5;

import java.util.Scanner;

public class LoanAmortizationSchedule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User inputs
        System.out.print("Enter loan amount: ");
        double loanAmount = input.nextDouble();
        System.out.print("Enter number of years: ");
        int years = input.nextInt();
        System.out.print("Enter annual interest rate (e.g., 5.5): ");
        double annualInterestRate = input.nextDouble();

        // Monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        // Number of monthly payments
        int numberOfPayments = years * 12;

        // Monthly payment calculation
        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfPayments));

        // Display the monthly payment and total payment
        double totalPayment = monthlyPayment * numberOfPayments;
        System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
        System.out.printf("Total Payment: %.2f\n\n", totalPayment);

        // Print amortization schedule header
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Payment#", "Interest", "Principal", "Balance");

        double balance = loanAmount;
        for (int month = 1; month <= numberOfPayments; month++) {
            // Monthly interest
            double interest = monthlyInterestRate * balance;

            // Principal paid
            double principal = monthlyPayment - interest;

            // Update remaining balance
            balance -= principal;

            // Display monthly details
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f\n", month, interest, principal, Math.max(balance, 0));
        }

        input.close();
    }
}
