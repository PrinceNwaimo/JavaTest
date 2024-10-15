package makingAdifference;

import java.util.Scanner;

public class FairTaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Define expense categories
        String[] categories = {
                "Housing", "Food", "Clothing", "Transportation",
                "Education", "Health Care", "Vacations"
        };

        // Array to store expenses in each category
        double[] expenses = new double[categories.length];

        // Prompt the user to enter their expenses for each category
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("Enter your yearly expense for %s: $", categories[i]);
            expenses[i] = input.nextDouble();
        }

        // Calculate total expenses
        double totalExpenses = 0.0;
        for (double expense : expenses) {
            totalExpenses += expense;
        }

        // Define the FairTax rate (23% or 0.23 as decimal)
        double fairTaxRate = 0.23;

        // Calculate the estimated FairTax
        double estimatedFairTax = totalExpenses * fairTaxRate;

        // Display the results
        System.out.printf("%nYour total yearly expenses: $%.2f%n", totalExpenses);
        System.out.printf("Your estimated FairTax (at 23%%): $%.2f%n", estimatedFairTax);

        input.close();
    }
}
