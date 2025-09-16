package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DisplaySelectedCustomersByNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        scanner.close();

        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[2].equals(lastName)) {
                    System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + " " + fields[2] + ", Balance: " + fields[3]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No customers found with the given last name.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
