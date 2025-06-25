package joyceArrays;

import java.util.Scanner;

public class PurchaseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Purchase[] purchases = new Purchase[5];

        for (int i = 0; i < purchases.length; i++) {
            int invoiceNumber;
            while (true) {
                System.out.print("Enter invoice number for purchase " + (i + 1) + " (between 1000 and 8000): ");
                invoiceNumber = scanner.nextInt();
                if (invoiceNumber >= 1000 && invoiceNumber <= 8000) {
                    break;
                }
                System.out.println("Invalid invoice number. Please try again.");
            }

            double saleAmount;
            while (true) {
                System.out.print("Enter sale amount for purchase " + (i + 1) + ": $");
                saleAmount = scanner.nextDouble();
                if (saleAmount >= 0) {
                    break;
                }
                System.out.println("Invalid sale amount. Please try again.");
            }

            purchases[i] = new Purchase(invoiceNumber, saleAmount);
        }

        System.out.println("\nPurchase Data:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        scanner.close();
    }

}
