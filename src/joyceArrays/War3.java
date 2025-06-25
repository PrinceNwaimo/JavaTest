package joyceArrays;

import java.util.Random;

public class War3 {
    public static void main(String[] args) {
        Card[] deck = createDeck();
        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;
        Random random = new Random();
        for (int i = 0; i < 26; i++) {
            int playerIndex = random.nextInt(deck.length);
            Card playerCard = deck[playerIndex];
            deck = removeCard(deck, playerIndex);
            int computerIndex = random.nextInt(deck.length);
            Card computerCard = deck[computerIndex];
            deck = removeCard(deck, computerIndex);
            System.out.println("Player's card: " + playerCard);
            System.out.println("Computer's card: " + computerCard);
            int playerValue = getCardValue(playerCard);
            int computerValue = getCardValue(computerCard);
            if (playerValue > computerValue) {
                playerWins++;
                System.out.println("Player wins!");
            } else if (playerValue < computerValue) {
                computerWins++;
                System.out.println("Computer wins!");
            } else {
                ties++;
                System.out.println("It's a tie!");
            }
        }
        System.out.println("Player wins: " + playerWins);
        System.out.println("Computer wins: " + computerWins);
        System.out.println("Ties: " + ties);
    }

    public static Card[] createDeck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        Card[] deck = new Card[52];
        int index = 0;
        for (String suit : suits) {
            for (String value : values) {
                deck[index] = new Card(suit, value);
                index++;
            }
        }
        return deck;
    }

    public static Card[] removeCard(Card[] deck, int index) {
        Card[] newDeck = new Card[deck.length - 1];
        System.arraycopy(deck, 0, newDeck, 0, index);
        System.arraycopy(deck, index + 1, newDeck, index, deck.length - index - 1);
        return newDeck;
    }

    public static int getCardValue(Card card) {
        String value = card.value;
        switch (value) {
            case "Ace":
                return 14;
            case "King":
                return 13;
            case "Queen":
                return 12;
            case "Jack":
                return 11;
            default:
                return Integer.parseInt(value);
        }
    }

}
