package joyceInheritance;

public class HighSchoolBaseballGame extends BaseballGame{
    private static final int NUM_INNINGS = 7;

    public HighSchoolBaseballGame(String team1Name, String team2Name) {
        super(team1Name, team2Name, NUM_INNINGS);
    }
}
