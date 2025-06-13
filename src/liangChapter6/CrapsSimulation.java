package liangChapter6;

import java.util.Random;

public class CrapsSimulation {
    public static void main(String[] args) {
        int wins = 0;
        int simulations = 10000;
        Random random = new Random();

        for (int i = 0; i < simulations; i++) {
            if (playCraps(random)) {
                wins++;
            }
        }

        System.out.println("Number of simulations: " + simulations);
        System.out.println("Number of wins: " + wins);
        System.out.println("Chance of winning: " + (wins / (double) simulations) * 100 + "%");
    }

    public static boolean playCraps(Random random) {
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;
        int sum = roll1 + roll2;

        if (sum == 2 || sum == 3 || sum == 12) {
            return false;
        } else if (sum == 7 || sum == 11) {
            return true;
        } else {
            int point = sum;
            while (true) {
                roll1 = random.nextInt(6) + 1;
                roll2 = random.nextInt(6) + 1;
                sum = roll1 + roll2;

                if (sum == point) {
                    return true;
                } else if (sum == 7) {
                    return false;
                }
            }
        }
    }

}
