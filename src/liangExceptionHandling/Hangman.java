package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = readWordsFromFile("hangman.txt");
        if (words == null) {
            System.out.println("Error reading words from file.");
            return;
        }

        String wordToGuess = words[(int) (Math.random() * words.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '*';
        }

        int misses = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("(Guess) Enter a letter in word ");
            printWord(guessedWord);
            System.out.print(" > ");
            String input = scanner.next();
            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char letter = input.charAt(0);
            boolean correct = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    guessedWord[i] = letter;
                    correct = true;
                }
            }

            if (!correct) {
                misses++;
                System.out.println("        " + letter + " is not in the word");
                System.out.println("You have " + (6 - misses) + " guesses left.");
                if (misses == 6) {
                    System.out.println("You lost. The word was " + wordToGuess);
                    break;
                }
            } else {
                if (isWordGuessed(guessedWord)) {
                    System.out.print("The word is ");
                    printWord(guessedWord);
                    System.out.println("\nYou guessed the word!");
                    break;
                }
            }
        }
    }

    private static String[] readWordsFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String content = scanner.useDelimiter("\\Z").next();
            scanner.close();
            return content.split("\\s+");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private static void printWord(char[] word) {
        for (char c : word) {
            System.out.print(c);
        }
    }

    private static boolean isWordGuessed(char[] word) {
        for (char c : word) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }
}
