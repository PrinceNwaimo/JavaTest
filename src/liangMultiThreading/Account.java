package liangMultiThreading;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        notifyAll(); // Notify all waiting threads
    }

    public synchronized void withdraw(double amount) {
        while (balance < amount) {
            try {
                System.out.println("Insufficient balance. Waiting...");
                wait(); // Wait for deposit
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        balance -= amount;
    }

    public synchronized double getBalance() {
        return balance;
    }
}


