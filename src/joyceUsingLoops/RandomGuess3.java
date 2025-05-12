package joyceUsingLoops;

import java.util.Scanner;

public class RandomGuess3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = 1 + (int) (Math.random() * 100);
        int attempts = 0;

        while (true) {
            System.out.print("Guess a number between 1 and 100: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }

}
