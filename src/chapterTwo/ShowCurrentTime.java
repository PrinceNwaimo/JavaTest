package chapterTwo;

public class ShowCurrentTime {
    public static void main(String[] args) {
       long totalMilliseconds = System.currentTimeMillis();

       long totalSeconds = totalMilliseconds/1000;

       long currentSeconds = totalSeconds % 60;
       long totalMinutes = totalSeconds / 60;
       long currentMinute = totalMinutes % 60;

       long totalHours = totalMinutes/60;
       long currentHour = totalHours % 24;

        System.out.println(" Current time is " + currentHour + ":" + currentMinute + ":" + currentSeconds + " GMT");
paint();
    }
    public static void paint(){
        double a = 6.5;
        a += a+1;
        System.out.println( (int) a);
    }
}
