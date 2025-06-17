package diettel6;

import java.util.Random;
import java.util.Scanner;

public class CoinTossSimulator {
    private enum Coin {
        HEADS, TAILS
    }

    private static int headsCount = 0;
    private static int tailsCount = 0;
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Coin Toss Simulator");
            System.out.println("1. Toss Coin");
            System.out.println("2. Display Results");
            System.out.println("3. Reset");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Coin result = flip();
                    System.out.println("You got: " + result);
                    if (result == Coin.HEADS) {
                        headsCount++;
                    } else {
                        tailsCount++;
                    }
                    break;
                case 2:
                    displayResults();
                    break;
                case 3:
                    reset();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static Coin flip() {
        return random.nextBoolean() ? Coin.HEADS : Coin.TAILS;
    }

    public static void displayResults() {
        System.out.println("Results:");
        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
        if (headsCount + tailsCount > 0) {
            System.out.println("Heads percentage: " + (headsCount * 100.0 / (headsCount + tailsCount)) + "%");
            System.out.println("Tails percentage: " + (tailsCount * 100.0 / (headsCount + tailsCount)) + "%");
        }
    }

    public static void reset() {
        headsCount = 0;
        tailsCount = 0;
        System.out.println("Results reset");
    }

}
