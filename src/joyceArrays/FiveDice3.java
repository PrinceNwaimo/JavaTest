package joyceArrays;

import java.util.Random;

public class FiveDice3 {
    public static void main(String[] args) {
        int[][] dice = rollDice();
        printDice(dice);
        int[] playerRanks = determineRank(dice);
        determineWinner(playerRanks, getValues(dice));
    }

    public static int[][] rollDice() {
        Random random = new Random();
        int[][] dice = new int[2][5];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                dice[i][j] = random.nextInt(6) + 1;
            }
        }
        return dice;
    }

    public static void printDice(int[][] dice) {
        System.out.println("Computer's dice:");
        for (int die : dice[0]) {
            System.out.print(die + " ");
        }
        System.out.println();
        System.out.println("Player's dice:");
        for (int die : dice[1]) {
            System.out.print(die + " ");
        }
        System.out.println();
    }

    public static int[] determineRank(int[][] dice) {
        int[] ranks = new int[2];
        for (int i = 0; i < 2; i++) {
            int[] counts = new int[6];
            for (int die : dice[i]) {
                counts[die - 1]++;
            }
            int maxCount = 0;
            for (int j = 0; j < 6; j++) {
                if (counts[j] > maxCount) {
                    maxCount = counts[j];
                }
            }
            ranks[i] = maxCount;
        }
        return ranks;
    }

    public static int[] getValues(int[][] dice) {
        int[] values = new int[2];
        for (int i = 0; i < 2; i++) {
            int[] counts = new int[6];
            for (int die : dice[i]) {
                counts[die - 1]++;
            }
            int maxCount = 0;
            int maxValue = 0;
            for (int j = 0; j < 6; j++) {
                if (counts[j] > maxCount) {
                    maxCount = counts[j];
                    maxValue = j + 1;
                } else if (counts[j] == maxCount && j + 1 > maxValue) {
                    maxValue = j + 1;
                }
            }
            values[i] = maxValue;
        }
        return values;
    }

    public static void determineWinner(int[] ranks, int[] values) {
        if (ranks[0] > ranks[1]) {
            System.out.println("Computer wins!");
        } else if (ranks[0] < ranks[1]) {
            System.out.println("Player wins!");
        } else {
            if (values[0] > values[1]) {
                System.out.println("Computer wins!");
            } else if (values[0] < values[1]) {
                System.out.println("Player wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }
}