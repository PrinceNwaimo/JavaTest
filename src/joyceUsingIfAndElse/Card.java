package joyceUsingIfAndElse;

public class Card {
    private int value;
    private String suit;

    public Card(int setValue, String setSuit) {
        setValue(setValue);
        suit = setSuit;
    }

    public void setValue(int setValue) {
        if (setValue < 1 || setValue > 13) {
            value = 1;
        } else {
            value = setValue;
        }
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
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
                valueStr = Integer.toString(value);
        }
        return valueStr + " of " + suit;
    }

}
