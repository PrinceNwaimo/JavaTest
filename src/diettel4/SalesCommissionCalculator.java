package diettel4;

import java.util.Scanner;

public class SalesCommissionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalSales = 0;
        int itemCount = 0;

        System.out.println("Enter the number of items sold:");
        itemCount = scanner.nextInt();

        int i = 0;
        while (i < itemCount) {
            System.out.println("Enter the value of item " + (i + 1));
            totalSales += scanner.nextDouble();
            i++;
        }

        double commission = totalSales * 0.09;
        double earnings = 200 + commission;

        System.out.printf("Total sales: $%.2f%n", totalSales);
        System.out.printf("Commission: $%.2f%n", commission);
        System.out.printf("Earnings: $%.2f%n", earnings);
    }

}
