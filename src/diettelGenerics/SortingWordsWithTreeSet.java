package diettelGenerics;

import java.util.Scanner;
import java.util.TreeSet;

public class SortingWordsWithTreeSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();

        String[] words = line.split("\\s+");
        TreeSet<String> sortedWords = new TreeSet<>();

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!cleanWord.isEmpty()) {
                sortedWords.add(cleanWord);
            }
        }
        System.out.println("Sorted words: " + sortedWords);
    }
}
