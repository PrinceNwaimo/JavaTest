package diettelArrays;

import java.util.Random;

public class DeckOfCards2 {
    private Card[] deck;
    private int currentCard;
    private Random random;

    public DeckOfCards2() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new Card[52];
        currentCard = 0;
        random = new Random();

        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(faces[i % 13], suits[i / 13]);
        }
    }

    public void shuffle() {
        currentCard = 0;
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }

    public static class Card {
        private String face;
        private String suit;

        public Card(String face, String suit) {
            this.face = face;
            this.suit = suit;
        }

        public String getFace() {
            return face;
        }

        public String getSuit() {
            return suit;
        }

        @Override
        public String toString() {
            return face + " of " + suit;
        }
    }

    public static class Hand {
        private Card[] cards;

        public Hand(Card[] cards) {
            this.cards = cards;
        }

        public boolean hasPair() {
            int[] counts = new int[13];
            for (Card card : cards) {
                counts[getFaceIndex(card.getFace())]++;
            }
            for (int count : counts) {
                if (count == 2) {
                    return true;
                }
            }
            return false;
        }
        public boolean hasTwoPairs() {
            int[] counts = new int[13];
            for (Card card : cards) {
                counts[getFaceIndex(card.getFace())]++;
            }
            int pairCount = 0;
            for (int count : counts) {
                if (count == 2) {
                    pairCount++;
                }
            }
            return pairCount == 2;
        }

        public boolean hasThreeOfAKind() {
            int[] counts = new int[13];
            for (Card card : cards) {
                counts[getFaceIndex(card.getFace())]++;
            }
            for (int count : counts) {
                if (count == 3) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFourOfAKind() {
            int[] counts = new int[13];
            for (Card card : cards) {
                counts[getFaceIndex(card.getFace())]++;
            }
            for (int count : counts) {
                if (count == 4) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFlush() {
            String suit = cards[0].getSuit();
            for (Card card : cards) {
                if (!card.getSuit().equals(suit)) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasStraight() {
            int[] faceIndices = new int[cards.length];
            for (int i = 0; i < cards.length; i++) {
                faceIndices[i] = getFaceIndex(cards[i].getFace());
            }
            java.util.Arrays.sort(faceIndices);
            for (int i = 0; i < faceIndices.length - 1; i++) {
                if (faceIndices[i + 1] - faceIndices[i] != 1) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasFullHouse() {
            int[] counts = new int[13];
            for (Card card : cards) {
                counts[getFaceIndex(card.getFace())]++;
            }
            boolean hasThree = false;
            boolean hasTwo = false;
            for (int count : counts) {
                if (count == 3) {
                    hasThree = true;
                } else if (count == 2) {
                    hasTwo = true;
                }
            }
            return hasThree && hasTwo;
        }


        public boolean hasRoyalFlush() {
            String[] royalFaces = {"Ace", "King", "Queen", "Jack", "Ten"};
            String suit = cards[0].getSuit();
            for (Card card : cards) {
                if (!card.getSuit().equals(suit)) {
                    return false;
                }
                boolean faceFound = false;
                for (String royalFace : royalFaces) {
                    if (card.getFace().equals(royalFace)) {
                        faceFound = true;
                        break;
                    }
                }
                if (!faceFound) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasStraightFlush() {
            // implementation
            String suit = cards[0].getSuit();
            for (Card card : cards) {
                if (!card.getSuit().equals(suit)) {
                    return false;
                }
            }
            int[] faceIndices = new int[cards.length];
            for (int i = 0; i < cards.length; i++) {
                faceIndices[i] = getFaceIndex(cards[i].getFace());
            }
            java.util.Arrays.sort(faceIndices);
            for (int i = 0; i < faceIndices.length - 1; i++) {
                if (faceIndices[i + 1] - faceIndices[i] != 1) {
                    return false;
                }
            }
            return true;
        }

        private int getFaceIndex(String face) {
            String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
            for (int i = 0; i < faces.length; i++) {
                if (face.equals(faces[i])) {
                    return i;
                }
            }
            return -1; // should not happen
        }
    }


}