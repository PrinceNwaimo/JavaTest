package joyceUsingLoops;



import joyceUsingIfAndElse.Die;

import java.util.Scanner;

public class TwoDice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Die die1 = new Die();
        Die die2 = new Die();

        System.out.print("Choose a number between 2 and 12: ");
        int targetNumber = scanner.nextInt();

        while (targetNumber < 2 || targetNumber > 12) {
            System.out.print("Invalid number. Please choose a number between 2 and 12: ");
            targetNumber = scanner.nextInt();
        }

        boolean won = false;
        for (int roll = 1; roll <= 3; roll++) {
            die1.roll();
            die2.roll();
            System.out.println("Roll " + roll + ": " + die1.getValue() + " + " + die2.getValue() + " = " + (die1.getValue() + die2.getValue()));

            if (die1.getValue() + die2.getValue() == targetNumber) {
                System.out.println("Congratulations! You won!");
                won = true;
                break;
            }
        }

        if (!won) {
            System.out.println("Sorry, you didn't roll your target number. The computer wins!");
        }

        scanner.close();
    }

}
