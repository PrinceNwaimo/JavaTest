package diettelGenericDataStructures;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("'" + input + "' is " + (isPalindrome(input) ? "a palindrome" : "not a palindrome"));
    }

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        String cleanedStr = cleanString(str);

        // Push first half of characters onto stack
        int length = cleanedStr.length();
        for (int i = 0; i < length / 2; i++) {
            stack.push(cleanedStr.charAt(i));
        }

        // Determine start index for comparison (handle odd-length strings)
        int compareStartIndex = (length % 2 == 0) ? length / 2 : length / 2 + 1;

        // Compare stacked chars (from first half) with second half chars
        for (int i = compareStartIndex; i < length; i++) {
            if (stack.pop() != cleanedStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String cleanString(String str) {
        // Remove spaces and punctuation, convert to lowercase
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}
