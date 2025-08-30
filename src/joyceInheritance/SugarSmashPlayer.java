package joyceInheritance;

public class SugarSmashPlayer {
    private int id;
    private String screenName;
    protected int[] scores;
    protected static final int MIN_SCORE = 100;

    public SugarSmashPlayer(int id, String screenName, int numLevels) {
        this.id = id;
        this.screenName = screenName;
        this.scores = new int[numLevels];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getScore(int level) {
        if (level < 1 || level > scores.length) {
            System.out.println("Error: Level is out of range.");
            return -1;
        }
        return scores[level - 1];
    }

    public void setScore(int score, int level) {
        if (level < 1 || level > scores.length) {
            System.out.println("Error: Level is out of range.");
            return;
        }
        if (level > 1 && getScore(level - 1) < MIN_SCORE) {
            System.out.println("Error: Previous level score is not sufficient to unlock this level.");
            return;
        }
        scores[level - 1] = score;
    }
}
