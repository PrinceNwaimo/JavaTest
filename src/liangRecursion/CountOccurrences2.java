package liangRecursion;

import java.util.Scanner;

public class CountOccurrences2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a character: ");
        char a = scanner.next().charAt(0);
        scanner.close();

        int count = count(str, a);
        System.out.println("The character '" + a + "' occurs " + count + " times in the string.");
    }

    public static int count(String str, char a) {
        return count(str, a, str.length() - 1);
    }

    public static int count(String str, char a, int high) {
        if (high < 0) {
            return 0;
        } else if (str.charAt(high) == a) {
            return 1 + count(str, a, high - 1);
        } else {
            return count(str, a, high - 1);
        }
    }
}
