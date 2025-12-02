package networkProgramming;
import java.io.Serializable;
public class Loaner implements Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    public Loaner(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}









