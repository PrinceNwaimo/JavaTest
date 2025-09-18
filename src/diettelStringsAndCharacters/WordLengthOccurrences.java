package diettelStringsAndCharacters;

import java.util.Scanner;

public class WordLengthOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine().toLowerCase();
        scanner.close();

        String[] words = text.split("\\s+");
        int maxLength = 0;
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-z]", "");
            maxLength = Math.max(maxLength, cleanWord.length());
        }

        int[] wordLengthCounts = new int[maxLength + 1];

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-z]", "");
            wordLengthCounts[cleanWord.length()]++;
        }

        System.out.println("Word length occurrences:");
        for (int i = 1; i <= maxLength; i++) {
            System.out.println(i + "-letter words: " + wordLengthCounts[i]);
        }
    }
}
