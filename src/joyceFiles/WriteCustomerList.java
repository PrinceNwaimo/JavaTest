package joyceFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteCustomerList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new FileWriter("customers.txt", true))) {
            while (true) {
                System.out.print("Enter ID number: ");
                String id = scanner.nextLine();
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter balance owed: ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                writer.println(id + "," + firstName + "," + lastName + "," + balance);

                System.out.print("Do you want to add another record? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
}
