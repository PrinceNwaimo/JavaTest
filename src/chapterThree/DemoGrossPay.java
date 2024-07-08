package chapterThree;

import static chapterThree.ParadiseInfo.calculateGross;

public class DemoGrossPay {
    public static void main(String[] args) {
        double hours = 25;
        double yourHoursWorked = 37.5;
        calculateGross(10);
        calculateGross(hours);
        calculateGross(yourHoursWorked);
    }
}
