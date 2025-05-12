package joyceUsingLoops;

public class IncreasedProduction {
    public static void main(String[] args) {
        double production = 4000;
        double increaseRate = 0.06;
        int raiseMonth = 0;

        System.out.println("Month\tProduction");

        for (int month = 1; month <= 24; month++) {
            System.out.printf("%d\t%.2f%n", month, production);

            if (production > 7000 && raiseMonth == 0) {
                raiseMonth = month;
            }

            production *= (1 + increaseRate);
        }

        if (raiseMonth > 0) {
            System.out.println("The worker deserves a raise in month " + raiseMonth);
        } else {
            System.out.println("The worker's production does not exceed 7000 parts within 24 months.");
        }
    }

}
