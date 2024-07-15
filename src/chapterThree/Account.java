package chapterThree;

import org.w3c.dom.ls.LSOutput;

public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance1) {
        this.name = name;
        if (balance1 > 0.0)
            balance = balance1;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance1) {
        balance = balance1;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0.0) {
            balance = balance + depositAmount;
        }
    }

    public void withdrawal(double withdraw) {
        if (withdraw < balance) {
            balance = balance - withdraw;
        } else {
            System.out.println("Inadequate amount");
        }
    }
}