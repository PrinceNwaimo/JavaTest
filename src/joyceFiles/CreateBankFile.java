package joyceFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CreateBankFile {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("bank.dat", "rw")) {
            // Create 10,000 blank records
            for (int i = 0; i < 10000; i++) {
                file.writeInt(0); // Account number
                byte[] name = new byte[8];
                for (int j = 0; j < 8; j++) {
                    name[j] = ' ';
                }
                file.write(name); // Last name
                file.writeDouble(0.0); // Balance
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter account number (0-9998): ");
                int accountNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                // Force name to 8 characters
                byte[] name = new byte[8];
                for (int i = 0; i < 8; i++) {
                    if (i < lastName.length()) {
                        name[i] = (byte) lastName.charAt(i);
                    } else {
                        name[i] = ' ';
                    }
                }

                // Write record to file
                file.seek(accountNumber * 24); // 4 bytes for account number + 8 bytes for name + 8 bytes for balance = 20 bytes, but using 24 for alignment
                file.writeInt(accountNumber);
                file.write(name);
                file.writeDouble(balance);

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
