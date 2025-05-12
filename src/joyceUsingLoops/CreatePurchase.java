package joyceUsingLoops;

import java.util.Scanner;

public class CreatePurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Purchase purchase = new Purchase();

        int invoiceNumber;
        while (true) {
            System.out.print("Enter invoice number (1000-8000): ");
            invoiceNumber = scanner.nextInt();
            if (invoiceNumber >= 1000 && invoiceNumber <= 8000) {
                break;
            }
            System.out.println("Invalid invoice number. Please try again.");
        }
        purchase.setInvoiceNumber(invoiceNumber);

        double saleAmount;
        while (true) {
            System.out.print("Enter sale amount (nonnegative): ");
            saleAmount = scanner.nextDouble();
            if (saleAmount >= 0) {
                break;
            }
            System.out.println("Invalid sale amount. Please try again.");
        }
        purchase.setSaleAmount(saleAmount);

        purchase.display();

        scanner.close();
    }

}
