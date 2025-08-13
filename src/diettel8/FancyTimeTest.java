package diettel8;

public class FancyTimeTest {
    public static void main(String[] args) {
        FancyTime time1 = new FancyTime(10, 30, 45, "a.m.");
        FancyTime time2 = new FancyTime(14, 30, 45);
        FancyTime time3 = new FancyTime(14, 30);

        System.out.println("Time 1:");
        time1.displayTime(1);
        time1.displayTime(2);
        time1.displayTime(3);

        System.out.println("Time 2:");
        time2.displayTime(1);
        time2.displayTime(2);
        time2.displayTime(3);

        System.out.println("Time 3:");
        time3.displayTime(1);
        time3.displayTime(2);
        time3.displayTime(3);
    }
}
