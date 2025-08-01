package diettelArrays;

public class CardShufflingAndDealing {
    public static void main(String[] args) {
        DeckOfCards2 deck = new DeckOfCards2();
        deck.shuffle();

        DeckOfCards2.Card[] playerHand = new DeckOfCards2.Card[5];
        DeckOfCards2.Card[] dealerHand = new DeckOfCards2.Card[5];

        for (int i = 0; i < 5; i++) {
            playerHand[i] = deck.dealCard();
            dealerHand[i] = deck.dealCard();
        }

        DeckOfCards2.Hand playerPokerHand = new DeckOfCards2.Hand(playerHand);
        DeckOfCards2.Hand dealerPokerHand = new DeckOfCards2.Hand(dealerHand);

        System.out.println("Player's hand:");
        for (DeckOfCards2.Card card : playerHand) {
            System.out.println(card);
        }
        System.out.println("Player's hand evaluation:");
        evaluateHand(playerPokerHand);

        System.out.println("\nDealer's hand:");
        for (DeckOfCards2.Card card : dealerHand) {
            System.out.println(card);
        }
        System.out.println("Dealer's hand evaluation:");
        evaluateHand(dealerPokerHand);

        // Determine which hand is better
        determineWinner(playerPokerHand, dealerPokerHand);
    }

    private static void evaluateHand(DeckOfCards2.Hand hand) {
        if (hand.hasFourOfAKind()) {
            System.out.println("Four of a kind");
        } else if (hand.hasFullHouse()) {
            System.out.println("Full house");
        } else if (hand.hasFlush()) {
            System.out.println("Flush");
        } else if (hand.hasStraight()) {
            System.out.println("Straight");
        } else if (hand.hasThreeOfAKind()) {
            System.out.println("Three of a kind");
        } else if (hand.hasTwoPairs()) {
            System.out.println("Two pairs");
        } else if (hand.hasPair()) {
            System.out.println("Pair");
        } else {
            System.out.println("High card");
        }
    }

    private static void determineWinner(DeckOfCards2.Hand playerHand, DeckOfCards2.Hand dealerHand) {
        int playerRank = getHandRank(playerHand);
        int dealerRank = getHandRank(dealerHand);

        if (playerRank > dealerRank) {
            System.out.println("Player wins!");
        } else if (playerRank < dealerRank) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static int getHandRank(DeckOfCards2.Hand hand) {
        if (hand.hasFourOfAKind()) {
            return 8;
        } else if (hand.hasFullHouse()) {
            return 7;
        } else if (hand.hasFlush()) {
            return 6;
        } else if (hand.hasStraight()) {
            return 5;
        } else if (hand.hasThreeOfAKind()) {
            return 4;
        } else if (hand.hasTwoPairs()) {
            return 3;
        } else if (hand.hasPair()) {
            return 2;
        } else {
            return 1;
        }
    }


}
