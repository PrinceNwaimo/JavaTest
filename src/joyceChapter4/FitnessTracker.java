package joyceChapter4;

public class FitnessTracker {
    private int minutes;
    private String date;
    private String activity;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FitnessTracker(int minutes, String date) {
        minutes = 0;
        date = "January 1";
    }

    public FitnessTracker(int minutes, String date, String activity) {
        this.minutes = minutes;
        this.date = date;
        this.activity = activity;
    }
}
