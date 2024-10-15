package diettel5;

public class ModifiedInterest {
    public static void main(String[] args) {
        double principal = 1000.0;
        System.out.printf("%s%20s%20s%n", "Year", "Rate", "Amount on deposit");
        for (double rate = 0.05; rate <= 0.10; rate += 0.01) {
            System.out.printf("%nInterest Rate: %.0f%%%n", rate * 100);

            for (int year = 1; year <= 10; ++year) {
                double amount = principal * Math.pow(1.0 + rate, year);
                System.out.printf("%4d%,20.2f%,20.2f%%%n", year, amount, rate * 100);
            }
        }
    }

}
