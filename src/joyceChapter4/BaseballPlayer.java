package joyceChapter4;

public class BaseballPlayer {
    private static int countOfPlayers = 0;
    private int number;
    private double battingAverage;

    public BaseballPlayer(int id, double avg)
    {
        number = id;
        battingAverage = avg;
        countOfPlayers = countOfPlayers + 1;
    }
    public void showPlayer()
    {
        System.out.println("Player #" + number +
                " batting average is " + battingAverage +
                " There are " + countOfPlayers + " players");
    }
}
