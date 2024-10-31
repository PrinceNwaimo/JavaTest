package liang5;

import java.util.Scanner;

public class LoanComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input loan amount and loan period
        System.out.print("Enter loan amount: ");
        double loanAmount = input.nextDouble();
        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        System.out.printf("%-15s %-15s %-15s%n", "Interest Rate", "Monthly Payment", "Total Payment");

        // Interest rates from 5% to 8% (incremented by 0.125)
        for (double annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate += 0.125) {
            // Monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            // Number of payments (months)
            int numberOfPayments = years * 12;

            // Monthly payment calculation
            double monthlyPayment = loanAmount * monthlyInterestRate /
                    (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfPayments));

            // Total payment calculation
            double totalPayment = monthlyPayment * numberOfPayments;

            // Display the results
            System.out.printf("%-15.3f %-15.2f %-15.2f%n", annualInterestRate, monthlyPayment, totalPayment);
        }

        input.close();
    }
}
