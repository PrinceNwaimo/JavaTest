package diettel6;

import java.security.SecureRandom;
import java.util.Scanner;

public class Craps {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private enum Status {CONTINUE, WON, LOST}

    ;

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        double bankBalance = 1000.0;
        while (true) {
            System.out.println("Your current balance is: $" + bankBalance);
            double wager = getWager(bankBalance);
            boolean win = playGame();
            if (win) {
                bankBalance += wager + 100;
                System.out.println("You won $100 bonus!");
                System.out.println(getChatter(true));
            } else {
                bankBalance -= wager;
                System.out.println(getChatter(false));
                if (bankBalance == 0) {
                    System.out.println("Sorry. You busted!");
                    break;
                }
            }
            System.out.println("Your new balance is: $" + bankBalance);
            System.out.println();
        }
    }

    public static boolean playGame() {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WIN or LOST

        int sumOfDice = rollDice(); // first roll of the dice
        switch (sumOfDice) {
            case SEVEN: //win with 7 on first roll
            case YO_LEVEN:// win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: //lose with 2 on first roll
            case TREY: //lose with 3 on first roll
            case BOX_CARS: //lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice; //remember the point
                System.out.printf("Point is %d%n", myPoint);
                break;
        }

        //while game is not complete
        while (gameStatus == Status.CONTINUE) {// not WON or LOST
            sumOfDice = rollDice(); //roll dice again

            //determine game status
            if (sumOfDice == myPoint) { //win by making point
                gameStatus = Status.WON;
            } else {
                if (sumOfDice == SEVEN) {// lose by rolling 7 before point
                    gameStatus = Status.LOST;
                }
            }
        }
        //display won or lost essage
        if (gameStatus == Status.WON) {
            System.out.println("Player wins!!! Congratulations");
            return true;
        } else {
            System.out.println("Player loses");
        }
        return false;
    }

    //roll dice, calculate sum and display results
    public static int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die roll
        int die2 = 1 + randomNumbers.nextInt(6); // second die roll

        int sum = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

        return sum;
    }

    public static double getWager(double bankBalance) {
        while (true) {
            System.out.print("Enter your wager: $");
            double wager = scanner.nextDouble();
            if (wager <= bankBalance && wager > 0) {
                return wager;
            } else {
                System.out.println("Invalid wager. Please enter a wager between $1 and $" + bankBalance);
            }
        }
    }

    public static String getChatter(boolean win) {
        String[] winChatter = {"You're on fire!", "You're up big. Now's the time to cash in your chips!", "Oh, you're going for broke, huh?"};
        String[] loseChatter = {"Aw c'mon, take a chance!", "Better luck next time!", "Don't get discouraged!"};
        if (win) {
            return winChatter[randomNumbers.nextInt(winChatter.length)];
        } else {
            return loseChatter[randomNumbers.nextInt(loseChatter.length)];
        }

    }
}