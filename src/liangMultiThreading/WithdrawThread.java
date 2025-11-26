package liangMultiThreading;

// WithdrawThread.java
public class WithdrawThread extends Thread {
    private Account account;

    public WithdrawThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(50);
        System.out.println("Withdrawn 50. Balance: " + account.getBalance());
    }
}
