package getterAndSetterPractice;

public class ClockTest {
    public static void main(String[] args) {
        Clock quartz = new Clock(06,30,45,"Quartz");
        System.out.printf("%s Time is %s%n",quartz.getName(),quartz.displayTime());
    }
}
