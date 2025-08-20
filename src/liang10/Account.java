package liang10;

import java.util.Scanner;

public class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class Maine {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an id: ");
            int id = scanner.nextInt();
            if (id >= 0 && id < accounts.length) {
                Account account = accounts[id];
                while (true) {
                    System.out.println("Main menu");
                    System.out.println("1: check balance");
                    System.out.println("2: withdraw");
                    System.out.println("3: deposit");
                    System.out.println("4: exit");
                    System.out.print("Enter a choice: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("The balance is " + account.getBalance());
                            break;
                        case 2:
                            System.out.print("Enter an amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter an amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    if (choice == 4) {
                        break;
                    }
                }
            } else {
                System.out.println("Invalid id. Please try again.");
            }
        }
    }
}
