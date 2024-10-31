package liang5;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userWins = 0;
        int computerWins = 0;

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Type 'rock', 'paper', or 'scissors' to play.");
        System.out.println("Type 'exit' to quit the game.");

        while (true) {
            System.out.print("Your choice: ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("exit")) {
                break;
            }

            // Generate computer choice
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[random.nextInt(choices.length)];

            // Display computer's choice
            System.out.println("Computer's choice: " + computerChoice);

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win!");
                userWins++;
            } else if ((computerChoice.equals("rock") && userChoice.equals("scissors")) ||
                    (computerChoice.equals("scissors") && userChoice.equals("paper")) ||
                    (computerChoice.equals("paper") && userChoice.equals("rock"))) {
                System.out.println("Computer wins!");
                computerWins++;
            } else {
                System.out.println("Invalid input, please enter rock, paper, or scissors.");
                continue; // Skip the rest of the loop if input is invalid
            }

            // Display current scores
            System.out.println("Your Wins: " + userWins + " | Computer Wins: " + computerWins);

            // Check if any player has more than twice the wins of the opponent
            if (userWins > 2 * computerWins) {
                System.out.println("You win the game!");
                break;
            } else if (computerWins > 2 * userWins) {
                System.out.println("Computer wins the game!");
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
