package chapterThree;
 import java.util.Scanner;

    public class HeadsOrTails {
        public static void main(String[] args) {
            int coinFlip = (int) (Math.random() * 2);
            Scanner input = new Scanner(System.in);
            System.out.print("Guess heads (0) or tails (1): ");
            int userGuess = input.nextInt();
            if (userGuess == coinFlip) {
                System.out.println("Correct! It was " + (coinFlip == 0 ? "heads" : "tails") + ".");
            } else {
                System.out.println("Incorrect. It was " + (coinFlip == 0 ? "heads" : "tails") + ".");
            }
        }
    }


