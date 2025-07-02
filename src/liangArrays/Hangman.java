package liangArrays;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"write", "that", "program", "hangman", "computer", "science", "java", "python"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        while (playAgain) {
            String word = words[random.nextInt(words.length)];
            char[] guessedWord = new char[word.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '*';
            }
            int misses = 0;
            boolean[] guessedLetters = new boolean[26];

            while (true) {
                System.out.print("(Guess) Enter a letter in word ");
                for (char c : guessedWord) {
                    System.out.print(c);
                }
                System.out.print(" > ");
                String input = scanner.next().toLowerCase();
                if (input.length() != 1) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }
                char letter = input.charAt(0);
                if (!Character.isLetter(letter)) {
                    System.out.println("Please enter a letter.");
                    continue;
                }
                int index = letter - 'a';
                if (guessedLetters[index]) {
                    System.out.println(letter + " is already guessed.");
                    continue;
                }
                guessedLetters[index] = true;

                boolean correctGuess = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        guessedWord[i] = letter;
                        correctGuess = true;
                    }
                }
                if (!correctGuess) {
                    System.out.println(letter + " is not in the word.");
                    misses++;
                }

                boolean wordGuessed = true;
                for (char c : guessedWord) {
                    if (c == '*') {
                        wordGuessed = false;
                        break;
                    }
                }
                if (wordGuessed) {
                    System.out.println("The word is " + word + ". You missed " + misses + " time" + (misses > 1 ? "s" : ""));
                    break;
                }
            }

            System.out.print("Do you want to guess another word? Enter y or n > ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("y");
        }
    }

}
