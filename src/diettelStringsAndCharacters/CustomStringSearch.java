package diettelStringsAndCharacters;

import java.util.Scanner;

public class CustomStringSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a substring: ");
        String substr = scanner.nextLine();
        scanner.close();

        System.out.println("Index of first occurrence: " + customIndexOf(str, substr));
        System.out.println("Index of last occurrence: " + customLastIndexOf(str, substr));
    }

    public static int customIndexOf(String str, String substr) {
        for (int i = 0; i <= str.length() - substr.length(); i++) {
            if (str.substring(i, i + substr.length()).equals(substr)) {
                return i;
            }
        }
        return -1;
    }

    public static int customLastIndexOf(String str, String substr) {
        for (int i = str.length() - substr.length(); i >= 0; i--) {
            if (str.substring(i, i + substr.length()).equals(substr)) {
                return i;
            }
        }
        return -1;
    }
}
