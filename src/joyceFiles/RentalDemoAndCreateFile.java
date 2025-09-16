package joyceFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RentalDemoAndCreateFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new FileWriter("rentals.txt"))) {
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter contract number: ");
                int contractNumber = scanner.nextInt();
                System.out.print("Enter rental time in hours: ");
                int hours = scanner.nextInt();
                System.out.print("Enter rental time in minutes: ");
                int minutes = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter equipment type code: ");
                String equipmentTypeCode = scanner.nextLine();
                System.out.print("Enter equipment type name: ");
                String equipmentTypeName = scanner.nextLine();
                System.out.print("Enter price: $");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                writer.println(contractNumber + "," + hours + "," + minutes + "," + equipmentTypeCode + "," + equipmentTypeName + "," + price);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
}

