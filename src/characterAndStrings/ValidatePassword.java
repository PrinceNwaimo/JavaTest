package characterAndStrings;

import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String password = "";

        while (!isValid) {
            System.out.println("Enter a password:");
            password = scanner.nextLine();
            String validationResult = validatePassword(password);

            if (validationResult.equals("valid")) {
                isValid = true;
                System.out.println("Password is valid.");
            } else {
                System.out.println("Password is not valid. Reason: " + validationResult);
            }
        }

        scanner.close();
    }

    public static String validatePassword(String password) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        if (uppercaseCount < 2) {
            return "Password must contain at least 2 uppercase letters.";
        } else if (lowercaseCount < 3) {
            return "Password must contain at least 3 lowercase letters.";
        } else if (digitCount < 1) {
            return "Password must contain at least 1 digit.";
        } else {
            return "valid";
        }
    }

}
