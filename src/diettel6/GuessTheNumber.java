package diettel6;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(1000) + 1;
            int numberOfTries = 0;

            System.out.println("Guess a number between 1 and 1000");
            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations. You guessed the number!");
                    System.out.println("It took you " + numberOfTries + " tries.");
                    break;
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            scanner.nextLine(); // Consume newline left-over
            String response = scanner.nextLine().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Invalid input. Please enter yes or no: ");
                response = scanner.nextLine().toLowerCase();
            }

            playAgain = response.equals("yes");
        }

        scanner.close();
    }

}
