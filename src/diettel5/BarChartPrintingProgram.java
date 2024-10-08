package diettel5;

import java.util.Scanner;

public class BarChartPrintingProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Read five numbers between 1 and 30
        System.out.println("Enter five numbers between 1 and 30:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();

            // Validate input
            while (numbers[i] < 1 || numbers[i] > 30) {
                System.out.print("Invalid input. Please enter a number between 1 and 30: ");
                numbers[i] = scanner.nextInt();
            }
        }

        // Display bar chart
        System.out.println("\nBar Chart:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Bar " + (i + 1) + ": ");
            for (int j = 0; j < numbers[i]; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        scanner.close();
    }

}
