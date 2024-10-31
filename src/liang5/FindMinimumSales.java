package liang5;
import java.util.Scanner;

public class FindMinimumSales {
    public static void main(String[] args) {
        final double BASE_SALARY = 5000.0; // Base salary
        final double TARGET_EARNINGS = 30000.0; // Target earnings

        // Commission rate brackets
        final double COMMISSION_RATE1 = 0.08; // 8% for the first $5,000
        final double COMMISSION_RATE2 = 0.10; // 10% for the next $5,000
        final double COMMISSION_RATE3 = 0.12; // 12% for any amount above $10,000

        Scanner scanner = new Scanner(System.in);

        double salesAmount = 0.0; // Total sales amount
        double commission = 0.0; // Total commission earned

        // Find the minimum sales amount to reach the target earnings
        while (BASE_SALARY + commission < TARGET_EARNINGS) {
            salesAmount += 0.01; // Increment sales amount by small steps for accuracy
            commission = calculateCommission(salesAmount, COMMISSION_RATE1, COMMISSION_RATE2, COMMISSION_RATE3);
        }

        System.out.printf("Minimum sales required to earn $30,000: $%.2f%n", salesAmount);
        scanner.close();
    }

    /**
     * Calculate the commission based on the sales amount.
     */
    private static double calculateCommission(double sales, double rate1, double rate2, double rate3) {
        double commission = 0.0;

        if (sales <= 5000) {
            commission = sales * rate1;
        } else if (sales <= 10000) {
            commission = (5000 * rate1) + ((sales - 5000) * rate2);
        } else {
            commission = (5000 * rate1) + (5000 * rate2) + ((sales - 10000) * rate3);
        }

        return commission;
    }
}
