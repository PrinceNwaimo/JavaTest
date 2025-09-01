package joyceInheritance;

public class BusinessLoan extends Loan{
    public BusinessLoan(int loanNumber, String customerLastName, double amount, int term, double primeRate) {
        super(loanNumber, customerLastName, amount, term);
        setInterestRate(primeRate);
    }

    @Override
    public void setInterestRate(double primeRate) {
        interestRate = primeRate + 0.01;
    }
}
