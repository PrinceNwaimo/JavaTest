package joyceChapter4;

public class FiveDice {
    public static void main(String[] args) {
        Die[] computerDice = new Die[5];
        Die[] playerDice = new Die[5];

        for (int i = 0; i < 5; i++) {
            computerDice[i] = new Die();
            playerDice[i] = new Die();
        }

        System.out.println("Computer's dice:");
        for (int i = 0; i < 5; i++) {
            System.out.print(computerDice[i].getValue() + " ");
        }
        System.out.println();

        System.out.println("Player's dice:");
        for (int i = 0; i < 5; i++) {
            System.out.print(playerDice[i].getValue() + " ");
        }
        System.out.println();
    }
}
