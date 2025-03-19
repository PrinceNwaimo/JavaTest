package joyceChapter4;

public class DogTriathlonParticipant {

    private final int Num_EVENTS;
    private static int totalCumulativeScore = 0;

    private String name;
    private int obedienceScore;
    private int conformationScore;
    private int agilityScore;
    private int total;
    private double avg;

    private boolean doScoresAgree;


    public DogTriathlonParticipant(String name, int numEvents, int score1, int score2, int score3) {
        this.name = name;
        Num_EVENTS = numEvents;
        obedienceScore = score1;
        conformationScore = score2;
        agilityScore = score3;
        total = obedienceScore + conformationScore + agilityScore;
        avg = (double) total / Num_EVENTS;
        totalCumulativeScore = totalCumulativeScore + total;

        if(Num_EVENTS == 0)
            avg = 0;
        else
            avg = (double) total / Num_EVENTS;

        int totalNot0 = 0;
        if(score1 != 0)
            totalNot0 = totalNot0 + 1;
        if(score2 != 0)
            totalNot0 = totalNot0 + 1;
        if(score3 != 0)
            totalNot0 = totalNot0 + 1;

    }


    public void display()
    {
        System.out.println(name + " participated in " + Num_EVENTS + " events and has an average score of " + avg);
        System.out.println(" " + name + " has a total score of " + total + " bringing the total cumulative score to " + totalCumulativeScore);
    }

}
