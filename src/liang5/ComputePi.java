package liang5;

public class ComputePi {
    public static void main(String[] args) {
        // Array of values for i
        int[] values = {10000, 20000, 100000};

        // Iterate through each value of i
        for (int i : values) {
            double piApproximation = 0.0;

            // Calculate the series sum
            for (int j = 0; j < i; j++) {
                // Add the terms of the series
                piApproximation += Math.pow(-1, j) / (2 * j + 1);
            }

            // Multiply by 4 to get the value of π
            piApproximation *= 4;

            // Display the result
            System.out.printf("Approximation of π for i = %d: %.10f\n", i, piApproximation);
        }
    }
}
