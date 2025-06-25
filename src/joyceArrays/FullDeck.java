package joyceArrays;

public class FullDeck {
    public static void main(String[] args) {
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
        for (Card card : deck) {
            System.out.println(card);
        }
    }

}
