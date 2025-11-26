package liangMultiThreading;

// ThreadCooperation.java
public class ThreadCooperation2 {
    public static void main(String[] args) {
        Account account = new Account(0);

        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);

        withdrawThread.start();
        depositThread.start();
    }
}
