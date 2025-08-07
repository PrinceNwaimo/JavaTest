package joyceTwoDimensionalArrays;

import joyceArrays.Purchase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortPurchasesArray {
    public static void main(String[] args) {
        Purchase[] purchases = new Purchase[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter invoice number for purchase " + (i + 1) + ": ");
            int invoiceNumber = scanner.nextInt();
            System.out.print("Enter sale amount for purchase " + (i + 1) + ": ");
            double saleAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            purchases[i] = new Purchase(invoiceNumber, saleAmount);
        }

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Sort by invoice number");
            System.out.println("2. Sort by sale amount");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    Arrays.sort(purchases, Comparator.comparingInt(Purchase::getInvoiceNumber));
                    break;
                case 2:
                    Arrays.sort(purchases, Comparator.comparing((Purchase::getSaleAmount)));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }

            System.out.println("Sorted Purchases:");
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }
    }

}
