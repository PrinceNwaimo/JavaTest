package joyceChapter3;

public class Card {
    private char suit;
    private int value;

    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String suitStr = "";
        switch (suit) {
            case 's':
                suitStr = "Spades";
                break;
            case 'h':
                suitStr = "Hearts";
                break;
            case 'd':
                suitStr = "Diamonds";
                break;
            case 'c':
                suitStr = "Clubs";
                break;
        }

        String valueStr = "";
        switch (value) {
            case 1:
                valueStr = "Ace";
                break;
            case 11:
                valueStr = "Jack";
                break;
            case 12:
                valueStr = "Queen";
                break;
            case 13:
                valueStr = "King";
                break;
            default:
                valueStr = String.valueOf(value);
        }

        return valueStr + " of " + suitStr;
    }
}
