package joyceInheritance;

public class DemoBaseballGame {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame("Team A", "Team B", 9);
        game.setTeam1Score(2, 1);
        game.setTeam2Score(1, 1);
        game.setTeam1Score(0, 2);
        game.setTeam2Score(3, 2);
        // ... set scores for all innings
        System.out.println("Winner: " + game.determineWinner());
    }
}
