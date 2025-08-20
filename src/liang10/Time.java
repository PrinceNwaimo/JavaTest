package liang10;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        long currentTime = System.currentTimeMillis();
        setTime(currentTime);
    }

    public Time(long elapseTime) {
        setTime(elapseTime);
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setTime(long elapseTime) {
        long totalSeconds = elapseTime / 1000;
        second = (int) (totalSeconds % 60);
        long totalMinutes = totalSeconds / 60;
        minute = (int) (totalMinutes % 60);
        long totalHours = totalMinutes / 60;
        hour = (int) (totalHours % 24);
    }

    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);

        System.out.println("Current Time: " + time1.getHour() + ":" + time1.getMinute() + ":" + time1.getSecond());
        System.out.println("Elapsed Time: " + time2.getHour() + ":" + time2.getMinute() + ":" + time2.getSecond());
    }
}
