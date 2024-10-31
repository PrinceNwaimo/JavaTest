package liang5;

import java.util.Scanner;

public class DecimalToOctal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int decimal = scanner.nextInt();

        // Handle negative numbers
        if (decimal < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }

        StringBuilder octal = new StringBuilder();

        // Convert decimal to octal
        if (decimal == 0) {
            octal.append("0"); // Handle the special case for 0
        } else {
            while (decimal > 0) {
                int remainder = decimal % 8; // Get the remainder
                octal.insert(0, remainder); // Prepend remainder to the octal string
                decimal /= 8; // Divide the number by 8
            }
        }

        System.out.println("The octal value is: " + octal);
        scanner.close();
    }
}

