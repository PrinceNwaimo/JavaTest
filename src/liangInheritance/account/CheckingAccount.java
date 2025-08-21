package liangInheritance.account;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit) {
        super(id, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }

    @Override
    public String toString() {
        return "Checking Account\n" + super.toString() + "\nOverdraft Limit: " + overdraftLimit;
    }
}
