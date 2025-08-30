package joyceInheritance;

public class BaseballGame {
    private String team1Name;
    private String team2Name;
    protected int[] team1Scores;
    protected int[] team2Scores;
    protected int numInnings;

    public BaseballGame(String team1Name, String team2Name, int numInnings) {
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.numInnings = numInnings;
        this.team1Scores = new int[numInnings];
        this.team2Scores = new int[numInnings];
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public int getTeam1Score(int inning) {
        if (inning < 1 || inning > numInnings) {
            System.out.println("Error: Inning is out of range.");
            return -1;
        }
        return team1Scores[inning - 1];
    }

    public void setTeam1Score(int score, int inning) {
        if (inning < 1 || inning > numInnings) {
            System.out.println("Error: Inning is out of range.");
            return;
        }
        if (inning > 1 && getTeam1Score(inning - 1) == 0) {
            System.out.println("Error: Previous inning score is not set.");
            return;
        }
        team1Scores[inning - 1] = score;
    }

    public int getTeam2Score(int inning) {
        if (inning < 1 || inning > numInnings) {
            System.out.println("Error: Inning is out of range.");
            return -1;
        }
        return team2Scores[inning - 1];
    }

    public void setTeam2Score(int score, int inning) {
        if (inning < 1 || inning > numInnings) {
            System.out.println("Error: Inning is out of range.");
            return;
        }
        if (inning > 1 && getTeam2Score(inning - 1) == 0) {
            System.out.println("Error: Previous inning score is not set.");
            return;
        }
        team2Scores[inning - 1] = score;
    }

    public String determineWinner() {
        int team1Total = 0;
        int team2Total = 0;
        for (int score : team1Scores) {
            team1Total += score;
        }
        for (int score : team2Scores) {
            team2Total += score;
        }
        if (team1Total > team2Total) {
            return team1Name;
        } else if (team2Total > team1Total) {
            return team2Name;
        } else {
            return "Tie";
        }
    }
}
