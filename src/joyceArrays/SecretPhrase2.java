package joyceArrays;

import java.util.Random;
import java.util.Scanner;

public class SecretPhrase2 {
    public static void main(String[] args) {
        String[] phrases = {
                "No man is an island",
                "The quick brown fox jumps over the lazy dog",
                "To be or not to be",
                "Romeo and Juliet",
                "All is fair in love and war",
                "The pen is mightier than the sword",
                "A bird in the hand is worth two in the bush",
                "The truth will set you free",
                "Actions speak louder than words",
                "The early bird catches the worm"
        };

        Random random = new Random();
        String phrase = phrases[random.nextInt(phrases.length)];
        char[] guessedPhrase = new char[phrase.length()];
        for (int i = 0; i < guessedPhrase.length; i++) {
            if (phrase.charAt(i) == ' ') {
                guessedPhrase[i] = ' ';
            } else {
                guessedPhrase[i] = '*';
            }
        }

        Scanner scanner = new Scanner(System.in);
        int incorrectGuesses = 0;
        while (true) {
            System.out.println("Phrase to guess: " + new String(guessedPhrase));
            System.out.print("Enter a letter: ");
            String input = scanner.next().toLowerCase();
            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            char letter = input.charAt(0);
            boolean correctGuess = false;
            for (int i = 0; i < phrase.length(); i++) {
                if (Character.toLowerCase(phrase.charAt(i)) == letter) {
                    guessedPhrase[i] = phrase.charAt(i);
                    correctGuess = true;
                }
            }
            if (!correctGuess) {
                incorrectGuesses++;
                System.out.println("Incorrect guess. You have " + (6 - incorrectGuesses) + " chances left.");
                if (incorrectGuesses == 6) {
                    System.out.println("You lost. The phrase was: " + phrase);
                    break;
                }
            } else {
                if (new String(guessedPhrase).replaceAll(" ", "").equals(phrase.replaceAll(" ", ""))) {
                    System.out.println("Phrase to guess: " + new String(guessedPhrase));
                    System.out.println("Congratulations! You guessed the phrase.");
                    break;
                }
            }
        }
    }

}
