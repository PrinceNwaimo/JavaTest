package diettelGenerics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateWordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Convert to lowercase and remove punctuation
        sentence = sentence.toLowerCase();
        sentence = sentence.replaceAll("[^a-z\\s]", "");

        // Split sentence into words
        String[] words = sentence.split("\\s+");

        // Count word occurrences
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        // Count duplicate words
        int duplicateWordCount = 0;
        for (int count : wordCounts.values()) {
            if (count > 1) {
                duplicateWordCount++;
            }
        }

        System.out.println("Number of duplicate words: " + duplicateWordCount);
    }
}
