package chapterThree;

import chapterThree.Account;

import java.util.Scanner;

public class AccountTest2 {
    public static void main(String[] args) {
        Account account1 = new Account("Prince James", 50.00);
        Account account2 = new Account("John Blue", -7.53);
        System.out.printf("%s balance: $%.2f%n" , account1.getName(),account1.getBalance());
        System.out.printf("%s balance: $%.2f%n ", account2.getName(), account2.getBalance());

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter deposit amount for account 1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account 1 balance%n%n", depositAmount);
        account1.deposit(depositAmount);

        System.out.printf("%s balance: $%.2f%n", account1.getName(),account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        System.out.print("Enter deposit amount for account 2: ");
        depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
        account2.deposit(depositAmount);

        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(),account2.getBalance());

        System.out.print("Enter amount to withdraw from account 1: ");
        double withdraw= input.nextDouble();
        System.out.printf("%nwithdrawing %.2f from account 1 : ",withdraw);
        account1.withdrawal(withdraw);

        System.out.println("Enter amount to withdraw from account 2: ");
        withdraw = input.nextDouble();
        System.out.printf("%nwithdrawing %.2f from account 2 : ",withdraw);
        account2.withdrawal(withdraw);

        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(),account2.getBalance());
    }
}
