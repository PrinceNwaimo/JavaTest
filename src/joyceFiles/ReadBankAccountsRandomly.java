package joyceFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadBankAccountsRandomly {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("bank.dat", "r");
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter account number (0-9998) or 9999 to quit: ");
                int accountNumber = scanner.nextInt();

                if (accountNumber == 9999) {
                    break;
                }

                file.seek(accountNumber * 24);
                int storedAccountNumber = file.readInt();
                byte[] name = new byte[8];
                file.read(name);
                double balance = file.readDouble();

                System.out.println("Account Number: " + storedAccountNumber);
                System.out.println("Last Name: " + new String(name).trim());
                System.out.println("Balance: " + balance);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
