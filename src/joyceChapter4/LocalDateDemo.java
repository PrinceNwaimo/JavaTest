package joyceChapter4;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate graduationDate = LocalDate.of(2016,5,29);
        System.out.println("Today is " + today);
        System.out.println("Graduation is " + graduationDate);

        System.out.println("Graduation will be on day "+graduationDate.getDayOfMonth() + " of " + graduationDate.getMonth());
    }
}
