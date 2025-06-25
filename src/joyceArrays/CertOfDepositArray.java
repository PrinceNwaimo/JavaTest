package joyceArrays;

import java.util.Scanner;

public class CertOfDepositArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CertOfDeposit[] certs = new CertOfDeposit[5];

        for (int i = 0; i < certs.length; i++) {
            System.out.print("Enter account number for CD " + (i + 1) + ": ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter balance for CD " + (i + 1) + ": $");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            System.out.print("Enter interest rate for CD " + (i + 1) + ": ");
            double interestRate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            System.out.print("Enter term in months for CD " + (i + 1) + ": ");
            int term = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            certs[i] = new CertOfDeposit(accountNumber, balance, interestRate, term);
        }

        System.out.println("\nCertificate of Deposit Data:");
        for (CertOfDeposit cert : certs) {
            System.out.println(cert);
        }

        scanner.close();
    }

}
