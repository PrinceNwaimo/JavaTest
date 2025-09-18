package diettelStringsAndCharacters;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine().toLowerCase();
        scanner.close();

        String[] words = text.split("\\s+");
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-z]", "");
            if (!cleanWord.isEmpty()) {
                wordCounts.put(cleanWord, wordCounts.getOrDefault(cleanWord, 0) + 1);
            }
        }

        System.out.println("Word occurrences:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
