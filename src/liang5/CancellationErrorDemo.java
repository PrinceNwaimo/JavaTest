package liang5;

public class CancellationErrorDemo {
    public static void main(String[] args) {
        int n = 50000;

        // Summing from left to right
        double sumLeftToRight = 0.0;
        for (int i = 1; i <= n; i++) {
            sumLeftToRight += 1.0 / i;
        }

        // Summing from right to left
        double sumRightToLeft = 0.0;
        for (int i = n; i >= 1; i--) {
            sumRightToLeft += 1.0 / i;
        }

        // Display results
        System.out.printf("Summation from left to right: %.15f\n", sumLeftToRight);
        System.out.printf("Summation from right to left: %.15f\n", sumRightToLeft);
        System.out.printf("Difference: %.15f\n", Math.abs(sumLeftToRight - sumRightToLeft));
    }
}
