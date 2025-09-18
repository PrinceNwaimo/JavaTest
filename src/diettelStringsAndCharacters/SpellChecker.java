package diettelStringsAndCharacters;

import java.util.Scanner;

public class SpellChecker {
    private String[] wordList;

    public SpellChecker(String[] wordList) {
        this.wordList = wordList;
    }

    public void checkSpelling(String word) {
        word = word.toLowerCase();
        for (String dictWord : wordList) {
            if (dictWord.equals(word)) {
                System.out.println("Word is spelled correctly.");
                return;
            }
        }

        System.out.println("Word is not spelled correctly.");
        suggestCorrections(word);
    }

    private void suggestCorrections(String word) {
        for (String dictWord : wordList) {
            if (isOneEditAway(word, dictWord)) {
                System.out.println("Did you mean \"" + dictWord + "\"?");
            }
        }
    }

    private boolean isOneEditAway(String word1, String word2) {
        if (Math.abs(word1.length() - word2.length()) > 1) {
            return false;
        }

        if (word1.length() == word2.length()) {
            // Check for single character replacement or transposition
            int diffCount = 0;
            boolean transposition = false;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1) {
                        return false;
                    }
                    if (i > 0 && word1.charAt(i) == word2.charAt(i - 1) && word1.charAt(i - 1) == word2.charAt(i)) {
                        transposition = true;
                    } else if (!transposition) {
                        transposition = false;
                    } else {
                        return false;
                    }
                }
            }
            return diffCount == 1 || (diffCount == 2 && transposition);
        } else if (word1.length() + 1 == word2.length()) {
            // Check for single character insertion
            return isInsertion(word1, word2);
        } else if (word1.length() - 1 == word2.length()) {
            // Check for single character deletion
            return isInsertion(word2, word1);
        }
        return false;
    }

    private boolean isInsertion(String shorterWord, String longerWord) {
        for (int i = 0; i <= longerWord.length() - shorterWord.length(); i++) {
            if (shorterWord.equals(longerWord.substring(0, i) + longerWord.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] wordList = {"apple", "banana", "orange", "grape", "default"};
        SpellChecker spellChecker = new SpellChecker(wordList);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        scanner.close();

        spellChecker.checkSpelling(word);
    }
}
