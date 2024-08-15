package chapterThree;

import java.util.Random;

public class PickACard {
    public static void main(String[] args) {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        Random random = new Random();

        int rankIndex = random.nextInt(ranks.length);
        int suitIndex = random.nextInt(suits.length);

        String rank = ranks[rankIndex];
        String suit = suits[suitIndex];

        System.out.println("You picked the " + rank + " of " + suit + ".");
    }

}
