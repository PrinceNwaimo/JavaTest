package liang5;

import java.util.Scanner;

public class ISBNCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ISBN (10 digits): ");
        String isbn = scanner.nextLine().trim();

        // Validate the length
        if (isbn.length() != 10) {
            System.out.println("Invalid ISBN: Must be 10 digits.");
            return;
        }

        // Calculate checksum
        int checksum = 0;

        for (int i = 0; i < 10; i++) {
            // Convert character to integer
            int digit = Character.getNumericValue(isbn.charAt(i));
            if (digit < 0 || digit > 9) {
                System.out.println("Invalid ISBN: All characters must be digits.");
                return;
            }
            checksum += (i + 1) * digit; // (i + 1) for the position
        }

        // Validate ISBN
        if (checksum % 11 == 0) {
            System.out.println("The ISBN " + isbn + " is valid.");
        } else {
            System.out.println("The ISBN " + isbn + " is invalid.");
        }

        scanner.close();
    }
}

