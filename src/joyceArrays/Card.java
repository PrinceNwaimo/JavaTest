package joyceArrays;

public class Card {
    private String suit;
    String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String toString() {
        return value + " of " + suit;
    }

}
