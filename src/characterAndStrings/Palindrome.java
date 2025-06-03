package characterAndStrings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a phrase:");
        String phrase = scanner.nextLine();

        String cleanedPhrase = cleanPhrase(phrase);
        boolean isPalindrome = isPalindrome(cleanedPhrase);

        if (isPalindrome) {
            System.out.println("The phrase is a palindrome.");
        } else {
            System.out.println("The phrase is not a palindrome.");
        }

        scanner.close();
    }

    public static String cleanPhrase(String phrase) {
        return phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static boolean isPalindrome(String phrase) {
        int left = 0;
        int right = phrase.length() - 1;

        while (left < right) {
            if (phrase.charAt(left) != phrase.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
