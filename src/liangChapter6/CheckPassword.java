package liangChapter6;

import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        if (isValidPassword(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        return digitCount >= 2;
    }

}
