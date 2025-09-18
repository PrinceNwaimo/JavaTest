package diettelStringsAndCharacters;

import java.util.Scanner;

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
            System.out.println("Password should:");
            System.out.println("  - Be between 8 and 15 characters long.");
            System.out.println("  - Start with an alphabet.");
            System.out.println("  - Contain at least one uppercase letter.");
            System.out.println("  - Contain at least one number.");
        }
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 15) {
            return false;
        }

        if (!Character.isLetter(password.charAt(0))) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasNumber = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }

        return hasUppercase && hasNumber;
    }
}
