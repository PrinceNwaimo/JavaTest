package joyceChapter4;

import java.time.LocalDate;

public class TestMonthHandling {
    public static void main(String[] args) {

        LocalDate jan31 = LocalDate.now().withMonth(1).withDayOfMonth(31);
        LocalDate dec31 = LocalDate.now().withMonth(12).withDayOfMonth(31);


        System.out.println("Original dates:");
        System.out.println("January 31: " + jan31);
        System.out.println("December 31: " + dec31);


        System.out.println("\nAdding months:");
        System.out.println("January 31 + 1 month: " + jan31.plusMonths(1));
        System.out.println("January 31 + 2 months: " + jan31.plusMonths(2));
        System.out.println("January 31 + 3 months: " + jan31.plusMonths(3));
        System.out.println("December 31 + 1 month: " + dec31.plusMonths(1));
        System.out.println("December 31 + 2 months: " + dec31.plusMonths(2));
        System.out.println("December 31 + 3 months: " + dec31.plusMonths(3));
    }
}
