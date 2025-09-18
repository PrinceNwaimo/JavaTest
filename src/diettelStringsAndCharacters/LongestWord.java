package diettelStringsAndCharacters;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        String[] words = sentence.split("\\s+");
        String longestWord = findLongestWord(words);

        System.out.println("The longest word is: " + longestWord);
    }

    public static String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            // Remove punctuation
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }
        return longestWord;
    }
}
