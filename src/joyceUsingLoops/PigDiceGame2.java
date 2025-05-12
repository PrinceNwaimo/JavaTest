package joyceUsingLoops;

import joyceUsingIfAndElse.Die;

import java.util.Scanner;

public class PigDiceGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Die die1 = new Die();
        Die die2 = new Die();
        int playerScore = 0;
        int computerScore = 0;

        while (playerScore < 100 && computerScore < 100) {
            // Player's turn
            System.out.println("Your turn. Your score: " + playerScore + ", Computer's score: " + computerScore);
            int playerTurnScore = 0;
            boolean playerTurnOver = false;
            while (!playerTurnOver) {
                die1.roll();
                die2.roll();
                System.out.println("You rolled: " + die1.getValue() + " + " + die2.getValue() + " = " + (die1.getValue() + die2.getValue()));

                if (die1.getValue() == 1 && die2.getValue() == 1) {
                    playerScore = 0;
                    System.out.println("Oh no! You rolled two 1s. Your score is reset to 0.");
                    playerTurnOver = true;
                } else if (die1.getValue() == 1 || die2.getValue() == 1) {
                    playerTurnScore = 0;
                    System.out.println("Sorry, you rolled a 1. Your turn score is reset to 0 and your turn is over.");
                    playerTurnOver = true;
                } else {
                    playerTurnScore += die1.getValue() + die2.getValue();
                    System.out.println("Your turn score: " + playerTurnScore);
                    System.out.print("Do you want to roll again? (yes/no): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("no")) {
                        playerScore += playerTurnScore;
                        playerTurnOver = true;
                    }
                }
            }

            if (playerScore >= 100) {
                break;
            }

            // Computer's turn
            System.out.println("Computer's turn. Your score: " + playerScore + ", Computer's score: " + computerScore);
            int computerTurnScore = 0;
            boolean computerTurnOver = false;
            while (!computerTurnOver) {
                die1.roll();
                die2.roll();
                System.out.println("Computer rolled: " + die1.getValue() + " + " + die2.getValue() + " = " + (die1.getValue() + die2.getValue()));

                if (die1.getValue() == 1 && die2.getValue() == 1) {
                    computerScore = 0;
                    System.out.println("Computer rolled two 1s. Computer's score is reset to 0.");
                    computerTurnOver = true;
                } else if (die1.getValue() == 1 || die2.getValue() == 1) {
                    computerTurnScore = 0;
                    System.out.println("Computer rolled a 1. Computer's turn score is reset to 0 and computer's turn is over.");
                    computerTurnOver = true;
                } else {
                    computerTurnScore += die1.getValue() + die2.getValue();
                    System.out.println("Computer's turn score: " + computerTurnScore);
                    double rollAgain = Math.random();
                    if (rollAgain < 0.5) {
                        computerScore += computerTurnScore;
                        computerTurnOver = true;
                    }
                }
            }
        }

        if (playerScore >= 100) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Sorry, the computer won!");
        }

        scanner.close();
    }

}
