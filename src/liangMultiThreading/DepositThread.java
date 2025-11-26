package liangMultiThreading;

// DepositThread.java
public class DepositThread extends Thread {
    private Account account;

    public DepositThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Simulate delay
            account.deposit(100);
            System.out.println("Deposited 100. Balance: " + account.getBalance());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
