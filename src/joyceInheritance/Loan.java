package joyceInheritance;

public abstract class Loan implements LoanConstants {
    protected int loanNumber;
    protected String customerLastName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Loan(int loanNumber, String customerLastName, double amount, int term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        if (amount > MAX_LOAN_AMOUNT) {
            this.amount = MAX_LOAN_AMOUNT;
        } else {
            this.amount = amount;
        }
        if (term != MEDIUM_TERM && term != LONG_TERM) {
            this.term = SHORT_TERM;
        } else {
            this.term = term;
        }
    }

    public abstract void setInterestRate(double primeRate);

    public double calculateTotalAmount() {
        return amount + (amount * interestRate * term);
    }

    @Override
    public String toString() {
        return "Loan Number: " + loanNumber +
                "\nCustomer Last Name: " + customerLastName +
                "\nAmount: $" + amount +
                "\nInterest Rate: " + interestRate +
                "\nTerm: " + term + " years" +
                "\nTotal Amount: $" + calculateTotalAmount();
    }
}
