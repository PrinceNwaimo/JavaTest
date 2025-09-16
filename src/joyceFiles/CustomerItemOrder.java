package joyceFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CustomerItemOrder {
    public static void main(String[] args) {
        try (RandomAccessFile customerFile = new RandomAccessFile("customers.dat", "r");
             RandomAccessFile itemFile = new RandomAccessFile("items.dat", "r");
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter customer ID (0-999): ");
                int customerId = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (customerId < 0 || customerId > 999) {
                    System.out.println("Invalid customer ID.");
                    continue;
                }

                customerFile.seek(customerId * 14);
                int id = customerFile.readInt();
                byte[] name = new byte[6];
                customerFile.read(name);
                int zipCode = customerFile.readInt();

                if (id == 0) {
                    System.out.println("Customer not found.");
                    continue;
                }

                System.out.println("Customer ID: " + id);
                System.out.println("Customer Name: " + new String(name).trim());
                System.out.println("Customer Zip Code: " + zipCode);

                System.out.print("Enter item number (0-999): ");
                int itemNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (itemNumber < 0 || itemNumber > 999) {
                    System.out.println("Invalid item number.");
                    continue;
                }

                itemFile.seek(itemNumber * 24);
                int itemId = itemFile.readInt();
                byte[] description = new byte[20];
                itemFile.read(description);

                if (itemId == 0) {
                    System.out.println("Item not found.");
                    continue;
                }

                System.out.println("Item Number: " + itemId);
                System.out.println("Item Description: " + new String(description).trim());

                System.out.print("Do you want to place another order? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
