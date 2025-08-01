package diettelArrays;

import java.util.Random;

public class Craps {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] wins = new int[22]; // Wins on roll 1-20 and after roll 20
        int[] losses = new int[22]; // Losses on roll 1-20 and after roll 20
        int totalWins = 0;
        int totalLosses = 0;
        int totalRolls = 0;

        for (int i = 0; i < 1000000; i++) {
            int rollCount = 0;
            int point = rollDice();
            rollCount++;

            if (point == 7 || point == 11) {
                wins[rollCount <= 20 ? rollCount : 21]++;
                totalWins++;
            } else if (point == 2 || point == 3 || point == 12) {
                losses[rollCount <= 20 ? rollCount : 21]++;
                totalLosses++;
            } else {
                while (true) {
                    rollCount++;
                    int roll = rollDice();
                    if (roll == point) {
                        wins[rollCount <= 20 ? rollCount : 21]++;
                        totalWins++;
                        break;
                    } else if (roll == 7) {
                        losses[rollCount <= 20 ? rollCount : 21]++;
                        totalLosses++;
                        break;
                    }
                }
            }
            totalRolls += rollCount;
        }

        System.out.println("Wins:");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Roll " + i + ": " + wins[i]);
        }
        System.out.println("After roll 20: " + wins[21]);

        System.out.println("\nLosses:");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Roll " + i + ": " + losses[i]);
        }
        System.out.println("After roll 20: " + losses[21]);

        System.out.println("\nChances of winning: " + (double) totalWins / (totalWins + totalLosses));
        System.out.println("Average length of a game: " + (double) totalRolls / 1000000);

        // Chances of winning do not necessarily improve with the length of the game
        // The probability of winning remains the same for each roll
    }

    private static int rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }

}
