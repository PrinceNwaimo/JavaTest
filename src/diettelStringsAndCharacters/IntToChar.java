package diettelStringsAndCharacters;

import java.util.Scanner;

public class IntToChar {
    public static void main(String[] args) {
        // Input an integer code and display the corresponding character
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer code: ");
        int code = scanner.nextInt();
        scanner.close();

        char character = (char) code;
        System.out.println("The character corresponding to code " + code + " is: " + character);

        // Generate all possible three-digit codes and attempt to print the corresponding characters
        System.out.println("Characters for three-digit codes:");
        for (int i = 0; i <= 255; i++) {
            String codeStr = String.format("%03d", i);
            char c = (char) i;
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c) || c == '.' || c == ',') {
                System.out.println(codeStr + ": " + c);
            } else {
                System.out.println(codeStr + ": Non-printable character");
            }
        }
    }
}
