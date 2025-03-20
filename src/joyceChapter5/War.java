package joyceChapter5;

import java.util.Random;

public class War {
    public static void main(String[] args) {
        Random rand = new Random();


        Card playerCard = new Card(rand.nextInt(13) + 1, getSuit(rand));
        Card computerCard = new Card(rand.nextInt(13) + 1, getSuit(rand));


        while (playerCard.getValue() == computerCard.getValue() && playerCard.getSuit().equals(computerCard.getSuit())) {
            computerCard = new Card(rand.nextInt(13) + 1, getSuit(rand));
        }


        System.out.println("Player's card: " + playerCard);
        System.out.println("Computer's card: " + computerCard);

        if (playerCard.getValue() > computerCard.getValue()) {
            System.out.println("Player wins!");
        } else if (playerCard.getValue() < computerCard.getValue()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }


    public static String getSuit(Random rand) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return suits[rand.nextInt(4)];
}

}
