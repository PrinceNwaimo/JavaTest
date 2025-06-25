package joyceArrays;

public class CertOfDeposit {
    private String accountNumber;
    private double balance;
    private double interestRate;
    private int term;

    public CertOfDeposit(String accountNumber, double balance, double interestRate, int term) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.term = term;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Balance: $" + balance +
                ", Interest Rate: " + interestRate + "%" +
                ", Term: " + term + " months";
    }

}
