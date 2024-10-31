package liang5;

    import java.util.Scanner;

    public class CheckISBN13 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter an ISBN-13 number
            System.out.print("Enter an ISBN-13 number: ");
            String isbn = scanner.nextLine();

            // Check if the ISBN is valid
            if (isValidISBN(isbn)) {
                System.out.println(isbn + " is a valid ISBN-13 number.");
            } else {
                System.out.println(isbn + " is not a valid ISBN-13 number.");
            }

            // Close the scanner
            scanner.close();
        }

        // Method to validate ISBN-13
        public static boolean isValidISBN(String isbn) {
            // Check if the input is exactly 13 characters long and all are digits
            if (isbn.length() != 13 || !isbn.matches("\\d+")) {
                return false;
            }

            int sum = 0;

            // Calculate the weighted sum based on the ISBN-13 formula
            for (int i = 0; i < 12; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));
                sum += (i % 2 == 0) ? digit : digit * 3; // Alternate between 1 and 3
            }

            // Calculate the checksum
            int checksum = (10 - (sum % 10)) % 10; // Checksum can be 0-9

            // Get the last digit from the input
            int lastDigit = Character.getNumericValue(isbn.charAt(12));

            // Compare the calculated checksum with the last digit
            return checksum == lastDigit;
        }
    }


