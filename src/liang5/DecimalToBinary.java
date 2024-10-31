package liang5;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int decimal = scanner.nextInt();

        // Handle negative numbers
        if (decimal < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }

        StringBuilder binary = new StringBuilder();

        // Convert decimal to binary
        if (decimal == 0) {
            binary.append("0"); // Handle the special case for 0
        } else {
            while (decimal > 0) {
                int remainder = decimal % 2; // Get the remainder
                binary.insert(0, remainder); // Prepend remainder to the binary string
                decimal /= 2; // Divide the number by 2
            }
        }

        System.out.println("The binary value is: " + binary);
        scanner.close();
    }
}
