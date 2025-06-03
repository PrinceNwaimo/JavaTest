package characterAndStrings;

import java.util.Scanner;

public class PhoneNumberFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter a 10-digit phone number (or 999 to quit):");
            input = scanner.nextLine();

            if (input.equals("999")) {
                break;
            }

            if (input.length() != 10 || !input.matches("\\d+")) {
                System.out.println("Error: Invalid phone number. Please enter exactly 10 digits.");
                continue;
            }

            String formattedPhoneNumber = formatPhoneNumber(input);
            System.out.println("Formatted phone number: " + formattedPhoneNumber);
        }

        scanner.close();
    }

    public static String formatPhoneNumber(String phoneNumber) {
        return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
    }

}
