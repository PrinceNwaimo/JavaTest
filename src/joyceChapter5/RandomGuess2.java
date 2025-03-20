package joyceChapter5;

import java.util.Random;
import java.util.Scanner;

public class RandomGuess2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;

        Scanner input = new Scanner(System.in);

        System.out.println("Guess a number between 1 and 100:");
        int userGuess = input.nextInt();

        if (userGuess == numberToGuess) {
            System.out.println("Congratulations! Your guess is correct.");
        } else if (userGuess < numberToGuess) {
            System.out.println("Your guess is too low. The number was " + numberToGuess + ".");
        } else {
            System.out.println("Your guess is too high. The number was " + numberToGuess + ".");
        }
    }

}
