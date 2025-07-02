package liangArrays;

import java.util.Random;

public class PickFourCards {
    public static void main(String[] args) {
        int count = 0;
        int totalPicks = 0;
        Random random = new Random();

        while (count < 1000) {
            int sum = 0;
            int picks = 0;
            boolean found = false;

            while (!found) {
                int card = random.nextInt(52);
                picks++;
                sum += getCardValue(card);

                if (sum == 24 && picks == 4) {
                    totalPicks += picks;
                    count++;
                    found = true;
                } else if (picks >= 4) {
                    found = true;
                }
            }
        }

        System.out.println("The average number of picks that yields the sum of 24: " + (double) totalPicks / count);
    }

    private static int getCardValue(int card) {
        int rank = card % 13;
        switch (rank) {
            case 0:
                return 1; // Ace
            case 10:
                return 11; // Jack
            case 11:
                return 12; // Queen
            case 12:
                return 13; // King
            default:
                return rank + 1; // 2-10
        }
    }

}
