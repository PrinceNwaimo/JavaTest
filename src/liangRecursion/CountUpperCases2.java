package liangRecursion;

import java.util.Scanner;

public class CountUpperCases2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of characters: ");
        String str = scanner.nextLine();
        scanner.close();

        char[] chars = str.toCharArray();
        int count = count(chars);
        System.out.println("The number of uppercase letters is: " + count);
    }

    public static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {
        if (high < 0) {
            return 0;
        } else if (Character.isUpperCase(chars[high])) {
            return 1 + count(chars, high - 1);
        } else {
            return count(chars, high - 1);
        }
    }
}
