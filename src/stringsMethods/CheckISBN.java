package stringsMethods;

import java.util.Scanner;

public class CheckISBN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN-10 number: ");
        String isbn = scanner.next();

        if (isbn.length() == 9 && isbn.matches("\\d+")) {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (i + 1) * (isbn.charAt(i) - '0');
            }
            int checksum = sum % 11;
            if (checksum == 10) {
                System.out.println("The ISBN-10 number is: " + isbn + "X");
            } else {
                System.out.println("The ISBN-10 number is: " + isbn + checksum);
            }
        } else {
            System.out.println("Invalid input. Please enter exactly 9 digits.");
        }
    }

}
