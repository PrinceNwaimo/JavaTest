package diettelStringsAndCharacters;

import java.util.Scanner;

public class LetterOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine().toLowerCase();
        scanner.close();

        int[] letterCounts = new int[26];

        for (char c = 'a'; c <= 'z'; c++) {
            int index = text.indexOf(c);
            while (index != -1) {
                letterCounts[c - 'a']++;
                index = text.indexOf(c, index + 1);
            }
        }

        System.out.println("Letter occurrences:");
        for (int i = 0; i < 26; i++) {
            System.out.println((char) ('a' + i) + ": " + letterCounts[i]);
        }
    }
}
