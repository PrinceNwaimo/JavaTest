package liang5;

import java.util.Scanner;

public class OccurrenceOfMaxNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer (0 to end): ");
        int max = scanner.nextInt(); // Read the first number

        // Check if the first number is 0
        if (max == 0) {
            System.out.println("No numbers were entered.");
            return;
        }

        int count = 1; // Initialize count for the max number

        while (true) {
            System.out.print("Enter an integer (0 to end): ");
            int number = scanner.nextInt(); // Read the next number

            if (number == 0) {
                break; // Exit the loop if the number is 0
            }

            // Compare with current max and update max and count accordingly
            if (number > max) {
                max = number; // Update max
                count = 1; // Reset count to 1
            } else if (number == max) {
                count++; // Increment count for occurrences of max
            }
        }

        // Display the results
        System.out.println("The largest number is: " + max);
        System.out.println("The occurrence count for " + max + " is: " + count);

        scanner.close();
    }
}

