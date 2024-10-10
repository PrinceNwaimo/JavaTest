package diettel5;

import java.util.Scanner;

public class Extremes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    // Prompt user for number of values
        System.out.print("Enter number of values: ");
    int numValues = scanner.nextInt();

    // Initialize min and max with first value
        System.out.print("Enter value 1: ");
    int minValue = scanner.nextInt();
    int maxValue = minValue;

    // Read remaining values and update min and max
        for (int i = 2; i <= numValues; i++) {
        System.out.print("Enter value " + i + ": ");
        int currentValue = scanner.nextInt();

        if (currentValue < minValue) {
            minValue = currentValue;
        } else if (currentValue > maxValue) {
            maxValue = currentValue;
        }
    }

    // Compute sum of extremes
    int sumExtremes = minValue + maxValue;

    // Display results
        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);
        System.out.println("Sum of extremes: " + sumExtremes);

        scanner.close();
}

}
