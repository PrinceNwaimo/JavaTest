package diettelFiles.transaction;

public class Account {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;

    public Account(int accountNumber, String firstName, String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void combine(TransactionRecord transaction) {
        balance += transaction.getAmount();
    }

    public double getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
