package liangRecursion;

import java.util.Scanner;

public class ReversedDisplay2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String value = scanner.nextLine();
        scanner.close();

        System.out.print("Reversed string: ");
        reverseDisplay(value);
    }

    public static void reverseDisplay(String value) {
        if (value.isEmpty()) {
            return;
        } else {
            reverseDisplay(value.substring(1));
            System.out.print(value.charAt(0));
        }
    }
}
