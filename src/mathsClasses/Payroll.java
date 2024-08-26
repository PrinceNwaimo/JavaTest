package mathsClasses;

import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of hours worked in a week: ");
        double hours = scanner.nextDouble();

        System.out.print("Enter hourly pay rate: ");
        double hourlyPay = scanner.nextDouble();

        System.out.print("Enter federal tax withholding rate (in %): ");
        double federalTaxRate = scanner.nextDouble() / 100;

        System.out.print("Enter state tax withholding rate (in %): ");
        double stateTaxRate = scanner.nextDouble() / 100;

        double grossPay = hours * hourlyPay;
        double federalTax = grossPay * federalTaxRate;
        double stateTax = grossPay * stateTaxRate;
        double totalTax = federalTax + stateTax;
        double netPay = grossPay - totalTax;

        System.out.println("\nPayroll Statement for " + name);
        System.out.printf("Hours worked: %.2f hours\n", hours);
        System.out.printf("Hourly pay rate: $%.2f\n", hourlyPay);
        System.out.printf("Gross pay: $%.2f\n", grossPay);
        System.out.printf("Federal tax withholding: $%.2f\n", federalTax);
        System.out.printf("State tax withholding: $%.2f\n", stateTax);
        System.out.printf("Total tax withholding: $%.2f\n", totalTax);
        System.out.printf("Net pay: $%.2f\n", netPay);
    }

}
