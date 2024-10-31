package liang5;

public class SumSeries {
    public static void main(String[] args) {
        double sum = 0.0;

        // Start from the first odd number 1 and iterate through odd numbers up to 97
        for (int i = 1; i <= 97; i += 2) {
            // For every odd number i, calculate the fraction
            if (i + 2 <= 99) { // Ensure we don't go out of bounds for the last fraction
                sum += (double) i / (i + 2);
            }
        }

        // Display the result
        System.out.printf("The sum of the series is: %.10f\n", sum);
    }
}
