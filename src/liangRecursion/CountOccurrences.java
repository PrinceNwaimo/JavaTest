package liangRecursion;

import java.util.Scanner;

public class CountOccurrences {
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
        if (str.isEmpty()) {
            return 0;
        } else if (str.charAt(0) == a) {
            return 1 + count(str.substring(1), a);
        } else {
            return count(str.substring(1), a);
        }
    }
}
