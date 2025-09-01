package joyceInheritance;

import java.util.Scanner;

public class CreateLoans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the current prime interest rate: ");
        double primeRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Loan[] loans = new Loan[5];
        int loanNumber = 1;

        for (int i = 0; i < loans.length; i++) {
            System.out.println("Enter loan type (Business/Personal): ");
            String loanType = scanner.nextLine();

            System.out.println("Enter customer last name: ");
            String customerLastName = scanner.nextLine();

            System.out.println("Enter loan amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over

            System.out.println("Enter loan term (1, 3, or 5 years): ");
            int term = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (loanType.equalsIgnoreCase("Business")) {
                loans[i] = new BusinessLoan(loanNumber, customerLastName, amount, term, primeRate);
            } else if (loanType.equalsIgnoreCase("Personal")) {
                loans[i] = new PersonalLoan(loanNumber, customerLastName, amount, term, primeRate);
            } else {
                System.out.println("Invalid loan type. Skipping...");
                continue;
            }

            loanNumber++;
        }

        System.out.println("\nLoan Details:");
        for (Loan loan : loans) {
            if (loan != null) {
                System.out.println(loan.toString());
                System.out.println();
            }
        }
    }
}
