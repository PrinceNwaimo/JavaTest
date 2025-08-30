package joyceInheritance;

public class LittleLeagueBaseballGame extends BaseballGame{
    private static final int NUM_INNINGS = 6;

    public LittleLeagueBaseballGame(String team1Name, String team2Name) {
        super(team1Name, team2Name, NUM_INNINGS);
    }
}
