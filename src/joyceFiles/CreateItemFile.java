package joyceFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CreateItemFile {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("items.dat", "rw")) {
            // Create empty file
            for (int i = 0; i < 1000; i++) {
                file.writeInt(0); // ID
                byte[] description = new byte[20];
                for (int j = 0; j < 20; j++) {
                    description[j] = ' ';
                }
                file.write(description); // Description
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter item number (0-999): ");
                int itemNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                // Check if item number already exists
                file.seek(itemNumber * 24);
                int existingItemNumber = file.readInt();
                if (existingItemNumber != 0) {
                    System.out.println("Error: Item number already exists.");
                    continue;
                }

                System.out.print("Enter item description: ");
                String description = scanner.nextLine();
                byte[] descBytes = new byte[20];
                for (int i = 0; i < 20; i++) {
                    if (i < description.length()) {
                        descBytes[i] = (byte) description.charAt(i);
                    } else {
                        descBytes[i] = ' ';
                    }
                }

                // Write record to file
                file.seek(itemNumber * 24);
                file.writeInt(itemNumber);
                file.write(descBytes);

                System.out.print("Do you want to add another record? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }

            }
            scanner.close();
            System.out.println("Thank you for your time!");
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
