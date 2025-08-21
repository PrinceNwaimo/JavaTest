package liangInheritance.account;

public class SavingsAccount extends Account{
    public SavingsAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return "Savings Account\n" + super.toString();
    }
}
