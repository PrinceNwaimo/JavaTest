package joyceFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StaffDinnerEventAndCreateFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new FileWriter("dinner_events.txt"))) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter event number: ");
                int eventNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter event type code: ");
                String eventTypeCode = scanner.nextLine();
                System.out.print("Enter number of guests: ");
                int numberOfGuests = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                writer.println(eventNumber + "," + eventTypeCode + "," + numberOfGuests + "," + price);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
}
