package joyceChapter4;

public class Game {
    private Team team1;
    private Team team2;
    private String gameTime;


    public Game(Team team1, Team team2, String gameTime) {
        this.team1 = team1;
        this.team2 = team2;
        this.gameTime = gameTime;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public String getGameTime() {
        return gameTime;
    }
}
