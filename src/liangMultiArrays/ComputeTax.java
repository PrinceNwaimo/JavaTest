package liangMultiArrays;

import java.util.Scanner;

public class ComputeTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define tax rates
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        // Define tax brackets
        int[][] brackets = {
                {8350, 33950, 82250, 171550, 372950}, // Single filer
                {16700, 67900, 137050, 208850, 372950}, // Married jointly or qualifying widow(er)
                {8350, 33950, 68525, 104425, 186475}, // Married separately
                {11950, 45500, 117450, 190200, 372950} // Head of household
        };

        // Prompt user to enter filing status
        System.out.println("Enter filing status:");
        System.out.println("0: Single filer");
        System.out.println("1: Married jointly or qualifying widow(er)");
        System.out.println("2: Married separately");
        System.out.println("3: Head of household");
        int status = scanner.nextInt();

        // Prompt user to enter taxable income
        System.out.print("Enter taxable income: ");
        double income = scanner.nextDouble();

        // Calculate tax
        double tax = calculateTax(status, income, rates, brackets);

        // Display result
        System.out.printf("Tax: %.2f%n", tax);
    }

    public static double calculateTax(int status, double income, double[] rates, int[][] brackets) {
        double tax = 0;
        int[] bracket = brackets[status];

        if (income <= bracket[0]) {
            tax = income * rates[0];
        } else if (income <= bracket[1]) {
            tax = bracket[0] * rates[0] + (income - bracket[0]) * rates[1];
        } else if (income <= bracket[2]) {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (income - bracket[1]) * rates[2];
        } else if (income <= bracket[3]) {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (bracket[2] - bracket[1]) * rates[2] + (income - bracket[2]) * rates[3];
        } else if (income <= bracket[4]) {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (bracket[2] - bracket[1]) * rates[2] + (bracket[3] - bracket[2]) * rates[3] + (income - bracket[3]) * rates[4];
        } else {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (bracket[2] - bracket[1]) * rates[2] + (bracket[3] - bracket[2]) * rates[3] + (bracket[4] - bracket[3]) * rates[4] + (income - bracket[4]) * rates[5];
        }

        return tax;
    }

}
