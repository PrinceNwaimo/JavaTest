package joyceInheritance;

public class PersonalLoan extends Loan{
    public PersonalLoan(int loanNumber, String customerLastName, double amount, int term, double primeRate) {
        super(loanNumber, customerLastName, amount, term);
        setInterestRate(primeRate);
    }

    @Override
    public void setInterestRate(double primeRate) {
        interestRate = primeRate + 0.02;
    }
}
