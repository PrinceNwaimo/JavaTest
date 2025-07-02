package liangArrays;

import java.util.Random;

public class CouponCollector {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        boolean[] suitCollected = new boolean[4];
        String[] collectedCards = new String[4];
        Random random = new Random();
        int numPicks = 0;
        int numSuitsCollected = 0;

        while (numSuitsCollected < 4) {
            String suit = suits[random.nextInt(4)];
            String rank = ranks[random.nextInt(13)];
            numPicks++;

            int suitIndex = getSuitIndex(suit, suits);
            if (!suitCollected[suitIndex]) {
                suitCollected[suitIndex] = true;
                collectedCards[suitIndex] = rank + " of " + suit;
                numSuitsCollected++;
            }
        }

        System.out.println("Collected cards: ");
        for (String card : collectedCards) {
            System.out.println(card);
        }
        System.out.println("Number of picks: " + numPicks);
    }

    private static int getSuitIndex(String suit, String[] suits) {
        for (int i = 0; i < suits.length; i++) {
            if (suit.equals(suits[i])) {
                return i;
            }
        }
        return -1; // Should not happen
    }

}
