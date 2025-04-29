package joyceUsingIfAndElse;

import java.time.LocalDate;
import java.util.Scanner;

public class PastPresentFuture2 {
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

        if (enteredDate.isBefore(currentDate)) {
            System.out.println("The entered date is in the past.");
        } else if (enteredDate.equals(currentDate)) {
            System.out.println("The entered date is the current date.");
        } else {
            System.out.println("The entered date is in the future.");
        }
    }

}
