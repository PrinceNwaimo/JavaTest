package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SecretPhraseUsingFiles {
    public static void main(String[] args) {
        ArrayList<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Phrases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                phrases.add(line.trim().toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (phrases.isEmpty()) {
            System.out.println("No phrases found in the file.");
            return;
        }

        Random random = new Random();
        String secretPhrase = phrases.get(random.nextInt(phrases.size()));
        char[] guessedPhrase = new char[secretPhrase.length()];
        for (int i = 0; i < guessedPhrase.length; i++) {
            if (secretPhrase.charAt(i) == ' ') {
                guessedPhrase[i] = ' ';
            } else {
                guessedPhrase[i] = '_';
            }
        }

        Scanner scanner = new Scanner(System.in);
        int incorrectGuesses = 0;
        while (true) {
            System.out.println("Secret phrase: " + new String(guessedPhrase));
            System.out.print("Enter your guess: ");
            String guess = scanner.next().toUpperCase();

            if (guess.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            boolean correctGuess = false;
            for (int i = 0; i < secretPhrase.length(); i++) {
                if (secretPhrase.charAt(i) == guess.charAt(0)) {
                    guessedPhrase[i] = guess.charAt(0);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                incorrectGuesses++;
                System.out.println("Incorrect guess. You have " + (6 - incorrectGuesses) + " chances left.");
            }

            if (new String(guessedPhrase).equals(secretPhrase)) {
                System.out.println("Congratulations! You guessed the phrase: " + secretPhrase);
                break;
            }

            if (incorrectGuesses == 6) {
                System.out.println("Game over. The secret phrase was: " + secretPhrase);
                break;
            }
        }
        scanner.close();
    }
}
