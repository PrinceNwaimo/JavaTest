package joyceChapter4;

public class FitnessTrackerTest {
    public static void main(String[] args) {
        FitnessTracker cardio = new FitnessTracker(2,"3-01-2025");
        cardio.setDate("3-01-2025");
        cardio.setMinutes(2);
        System.out.println(cardio.getDate()+","+cardio.getMinutes());
    }
}
