package joyceFiles;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadBankAccountsSequentially {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("bank.dat", "r")) {
            file.seek(0);
            for (int i = 0; i < 10000; i++) {
                int accountNumber = file.readInt();
                byte[] name = new byte[8];
                file.read(name);
                double balance = file.readDouble();

                if (accountNumber != 0) {
                    System.out.println("Account Number: " + accountNumber);
                    System.out.println("Last Name: " + new String(name).trim());
                    System.out.println("Balance: " + balance);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
