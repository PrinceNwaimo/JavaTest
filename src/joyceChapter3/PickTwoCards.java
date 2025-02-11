package joyceChapter3;

public class PickTwoCards {
    public static void main(String[] args) {
        final int CARDS_IN_SUIT = 13;
        Card card1 = new Card('s', (int) (Math.random() * 100) % CARDS_IN_SUIT + 1);
        Card card2 = new Card('h', (int) (Math.random() * 100) % CARDS_IN_SUIT + 1);

        System.out.println("Card 1: " + card1.toString());
        System.out.println("Card 2: " + card2.toString());
    }
}
