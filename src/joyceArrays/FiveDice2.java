package joyceArrays;

import java.util.Random;

public class FiveDice2 {
    public static void main(String[] args) {
        int[][] dice = rollDice();
        printDice(dice);
        int[] playerRanks = determineRank(dice);
        determineWinner(playerRanks);
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
            for (int j = 0; j < 6; j++) {
                if (counts[j] == 5) {
                    ranks[i] = 4; // Five of a kind
                    break;
                } else if (counts[j] == 4) {
                    ranks[i] = 3; // Four of a kind
                    break;
                } else if (counts[j] == 3) {
                    ranks[i] = 2; // Three of a kind
                    break;
                } else if (counts[j] == 2) {
                    ranks[i] = 1; // A pair
                    break;
                }
            }
        }
        return ranks;
    }

    public static void determineWinner(int[] ranks) {
        if (ranks[0] > ranks[1]) {
            System.out.println("Computer wins!");
        } else if (ranks[0] < ranks[1]) {
            System.out.println("Player wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }



    }
