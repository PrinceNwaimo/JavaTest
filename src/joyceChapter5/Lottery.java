package joyceChapter5;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {

        Random rand = new Random();
        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);
        int num3 = rand.nextInt(10);


        Scanner input = new Scanner(System.in);

        System.out.println("Guess three numbers between 0 and 9:");
        System.out.print("Enter your first guess: ");
        int guess1 = input.nextInt();
        System.out.print("Enter your second guess: ");
        int guess2 = input.nextInt();
        System.out.print("Enter your third guess: ");
        int guess3 = input.nextInt();


        int matches = 0;
        if (guess1 == num1 || guess1 == num2 || guess1 == num3) matches++;
        if (guess2 == num1 || guess2 == num2 || guess2 == num3) matches++;
        if (guess3 == num1 || guess3 == num2 || guess3 == num3) matches++;


        boolean exactMatch = (guess1 == num1 && guess2 == num2 && guess3 == num3);


        System.out.println("Your guesses: " + guess1 + ", " + guess2 + ", " + guess3);
        System.out.println("The winning numbers: " + num1 + ", " + num2 + ", " + num3);

        int winnings = 0;
        if (exactMatch) {
            winnings = 1_000_000;
        } else if (matches == 3) {
            winnings = 1_000;
        } else if (matches == 2) {
            winnings = 100;
        } else if (matches == 1) {
            winnings = 10;
        }

        System.out.println("Your winnings: $" + winnings);
    }

}
