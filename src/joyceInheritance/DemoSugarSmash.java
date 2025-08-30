package joyceInheritance;

public class DemoSugarSmash {
    public static void main(String[] args) {
        SugarSmashPlayer player1 = new SugarSmashPlayer(1, "Player1",5);
        player1.setScore(120, 1);
        player1.setScore(100, 2);
        System.out.println("Player 1 Score in Level 1: " + player1.getScore(1));
        System.out.println("Player 1 Score in Level 2: " + player1.getScore(2));

        PremiumSugarSmashPlayer player2 = new PremiumSugarSmashPlayer(2, "Player2");
        player2.setScore(150, 1);
        player2.setScore(120, 2);
        player2.setScore(100, 11);
        System.out.println("Player 2 Score in Level 1: " + player2.getScore(1));
        System.out.println("Player 2 Score in Level 2: " + player2.getScore(2));
        System.out.println("Player 2 Score in Level 11: " + player2.getScore(11));
    }
}
