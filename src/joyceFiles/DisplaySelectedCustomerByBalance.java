package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DisplaySelectedCustomerByBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum balance: ");
        double minBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        scanner.close();

        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                double balance = Double.parseDouble(fields[3]);
                if (balance > minBalance) {
                    System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + " " + fields[2] + ", Balance: " + fields[3]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No customers found with balance greater than $" + minBalance);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
