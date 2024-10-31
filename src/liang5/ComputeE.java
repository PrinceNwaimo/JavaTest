package liang5;

public class ComputeE {
    public static void main(String[] args) {
        // Array of values for i
        int[] values = {10000, 20000, 100000};

        // Iterate through each value of i
        for (int i : values) {
            double eApproximation = 1.0;  // Initialize e with 1
            double item = 1.0;            // Initialize the first term (1/0!)

            // Calculate the series sum
            for (int j = 1; j <= i; j++) {
                item /= j;  // Compute 1/j! by dividing the previous term by j
                eApproximation += item;  // Add the current term to the approximation
            }

            // Display the result
            System.out.printf("Approximation of e for i = %d: %.10f\n", i, eApproximation);
        }
    }
}
