package diettelArrays;

import java.security.SecureRandom;

public class ArcheryGame {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[][] scores = new int[4][3]; // 4 players, 3 chances each

        // Generate scores for each player
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = random.nextInt(11); // Generate score between 0 and 10
            }
        }

        // Calculate total score for each player
        int[] totalScores = new int[4];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                totalScores[i] += scores[i][j];
            }
        }

        // Print scores in tabular format
        System.out.println("Player\tChance 1\tChance 2\tChance 3\tTotal Score");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println(totalScores[i]);
        }

        // Determine the winner
        int winnerIndex = 0;
        int maxScore = totalScores[0];
        for (int i = 1; i < totalScores.length; i++) {
            if (totalScores[i] > maxScore) {
                winnerIndex = i;
                maxScore = totalScores[i];
            }
        }

        System.out.println("Player " + (winnerIndex + 1) + " wins with a total score of " + maxScore);
    }

}
