package liang5;

public class Summation {
    public static void main(String[] args) {
        // Set the upper limit for the summation
        int n = 2625;
        double sum = 0.0;

        // Compute the summation
        for (int k = 1; k <= n; k++) {
            sum += 1.0 / ((2 * k - 1) + (2 * k));
        }

        // Display the result
        System.out.printf("The result of the summation is: %.6f\n", sum);
    }
}
