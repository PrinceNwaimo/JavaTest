package makingAdifference;

import java.util.Scanner;

public class FairTaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String[] categories = {
                "Housing", "Food", "Clothing", "Transportation",
                "Education", "Health Care", "Vacations"
        };


        double[] expenses = new double[categories.length];


        for (int i = 0; i < categories.length; i++) {
            System.out.printf("Enter your yearly expense for %s: $", categories[i]);
            expenses[i] = input.nextDouble();
        }


        double totalExpenses = 0.0;
        for (double expense : expenses) {
            totalExpenses += expense;
        }


        double fairTaxRate = 0.23;


        double estimatedFairTax = totalExpenses * fairTaxRate;


        System.out.printf("%nYour total yearly expenses: $%.2f%n", totalExpenses);
        System.out.printf("Your estimated FairTax (at 23%%): $%.2f%n", estimatedFairTax);

        input.close();
    }
}
