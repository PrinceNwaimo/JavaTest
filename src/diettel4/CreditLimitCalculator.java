package diettel4;

import java.util.Scanner;

public class CreditLimitCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int customerCount = 0;

        while (customerCount < 3) {
            System.out.println("Enter account number:");
            int accountNumber = scanner.nextInt();

            System.out.println("Enter beginning balance:");
            int beginningBalance = scanner.nextInt();

            System.out.println("Enter total charges:");
            int charges = scanner.nextInt();

            System.out.println("Enter total credits:");
            int credits = scanner.nextInt();

            System.out.println("Enter credit limit:");
            int creditLimit = scanner.nextInt();

            int newBalance = beginningBalance + charges - credits;

            System.out.printf("Account number: %d%n", accountNumber);
            System.out.printf("New balance: %d%n", newBalance);

            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded");
            }

            customerCount++;
        }
    }

}
