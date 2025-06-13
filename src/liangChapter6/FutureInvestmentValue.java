package liangChapter6;

import java.util.Scanner;

public class FutureInvestmentValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the investment amount:");
        double investmentAmount = scanner.nextDouble();

        System.out.println("Enter the annual interest rate (in %):");
        double annualInterestRate = scanner.nextDouble() / 100;

        double monthlyInterestRate = annualInterestRate / 12;

        System.out.println("The amount invested: " + investmentAmount);
        System.out.println("Annual interest rate: " + annualInterestRate * 100 + "%");
        System.out.println("Years\tFuture Value");

        for (int years = 1; years <= 30; years++) {
            double futureValue = futureInvestmentValue(investmentAmount, monthlyInterestRate, years);
            System.out.printf("%d\t%.2f\n", years, futureValue);
        }

        scanner.close();
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }

}
