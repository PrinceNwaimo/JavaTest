package liang5;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for input between 1 and 15
        System.out.print("Enter the number of lines (1 to 15): ");
        int lines = input.nextInt();

        // Validate input
        if (lines < 1 || lines > 15) {
            System.out.println("Please enter a number between 1 and 15.");
            return;
        }

        // Generate the pyramid
        for (int i = 1; i <= lines; i++) {
            // Print leading spaces
            for (int j = 0; j < lines - i; j++) {
                System.out.print("   ");
            }

            // Print descending numbers
            for (int j = i; j >= 1; j--) {
                System.out.printf("%2d ", j);
            }

            // Print ascending numbers
            for (int j = 2; j <= i; j++) {
                System.out.printf("%2d ", j);
            }

            // Move to the next line
            System.out.println();
        }
    }
}
