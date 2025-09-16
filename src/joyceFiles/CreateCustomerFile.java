package joyceFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CreateCustomerFile {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("customers.dat", "rw")) {
            // Create empty file
            for (int i = 0; i < 1000; i++) {
                file.writeInt(0); // ID
                byte[] name = new byte[6];
                for (int j = 0; j < 6; j++) {
                    name[j] = ' ';
                }
                file.write(name); // Last name
                file.writeInt(0); // Zip code
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter ID (0-999): ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                // Check if ID already exists
                file.seek(id * 14);
                int existingId = file.readInt();
                if (existingId != 0) {
                    System.out.println("Error: ID already exists.");
                    continue;
                }

                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                byte[] name = new byte[6];
                for (int i = 0; i < 6; i++) {
                    if (i < lastName.length()) {
                        name[i] = (byte) lastName.charAt(i);
                    } else {
                        name[i] = ' ';
                    }
                }

                System.out.print("Enter zip code: ");
                int zipCode = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                // Write record to file
                file.seek(id * 14);
                file.writeInt(id);
                file.write(name);
                file.writeInt(zipCode);

                System.out.print("Do you want to add another record? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
