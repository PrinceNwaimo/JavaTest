package characterAndStrings;

import java.util.Scanner;

public class Alphabetize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        System.out.println("Enter the third string:");
        String str3 = scanner.nextLine();

        if (isAlphabeticalOrder(str1, str2, str3)) {
            System.out.println("The strings are in alphabetical order.");
        } else {
            System.out.println("The strings are not in alphabetical order.");
        }

        scanner.close();
    }
    public static boolean isAlphabeticalOrder(String str1, String str2, String str3) {
        return str1.compareToIgnoreCase(str2) <= 0 && str2.compareToIgnoreCase(str3) <= 0;
    }


}
