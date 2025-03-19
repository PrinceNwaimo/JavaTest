package joyceChapter5;

import java.time.LocalDate;
import java.util.Scanner;

public class PastPresentFuture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        LocalDate enteredDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        if (enteredDate.getYear() != currentDate.getYear()) {
            System.out.println("The entered date is not this year.");
        } else if (enteredDate.getMonthValue() < currentDate.getMonthValue()) {
            System.out.println("The entered date is in an earlier month this year.");
        } else if (enteredDate.getMonthValue() > currentDate.getMonthValue()) {
            System.out.println("The entered date is in a later month this year.");
        } else {
            System.out.println("The entered date is this month.");
        }
    }

}
