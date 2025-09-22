package liangRecursion;

import java.util.Scanner;

public class ReversedDisplay3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String value = scanner.nextLine();
        scanner.close();

        System.out.print("Reversed string: ");
        reverseDisplay(value);
    }

    public static void reverseDisplay(String value) {
        reverseDisplay(value, value.length() - 1);
    }

    public static void reverseDisplay(String value, int high) {
        if (high >= 0) {
            System.out.print(value.charAt(high));
            reverseDisplay(value, high - 1);
        }
    }
}
