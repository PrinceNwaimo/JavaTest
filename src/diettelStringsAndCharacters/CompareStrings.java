package diettelStringsAndCharacters;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        System.out.print("Enter the number of characters to compare: ");
        int length = scanner.nextInt();

        System.out.print("Enter the starting index for the first string: ");
        int index1 = scanner.nextInt();

        System.out.print("Enter the starting index for the second string: ");
        int index2 = scanner.nextInt();

        scanner.close();

        boolean result = str1.regionMatches(true, index1, str2, index2, length);

        if (result) {
            System.out.println("The compared characters are equal.");
        } else {
            System.out.println("The compared characters are not equal.");
        }
    }
}
