package chapterThree;

import static chapterThree.ReturnTypes.calculateGross1;

public class MethodChainCalls {
    public static void main(String[] args) {
        System.out.println(calculateNetPay(100, 5000));
    }
    public static double calculateNetPay(double hours, double rate){
        double gross;
        double withholding;
        double net;
        gross = calculateGross1(hours,rate);
        withholding = calculateWithHolding(gross);
        net = gross - withholding;
        return net;

    }

    public static double calculateWithHolding(double gross) {
        double fixedAmount = 100;
        double withhold;
        withhold = gross - fixedAmount;
        return withhold;
    }
}
