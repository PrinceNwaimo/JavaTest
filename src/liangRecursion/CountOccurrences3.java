package liangRecursion;

import java.util.Scanner;

public class CountOccurrences3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of characters: ");
        String str = scanner.nextLine();
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);
        scanner.close();

        char[] chars = str.toCharArray();
        int count = count(chars, ch);
        System.out.println("The character '" + ch + "' occurs " + count + " times in the list.");
    }

    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {
        if (high < 0) {
            return 0;
        } else if (chars[high] == ch) {
            return 1 + count(chars, ch, high - 1);
        } else {
            return count(chars, ch, high - 1);
        }
    }
}
