package chapterThree;

import java.util.Scanner;

public class NumberOfDays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month and year: ");
        int month = input.nextInt();
        int year = input.nextInt();
        String monthName = MonthName(month);

        if (month == 2) {
            if (isLeapYear(year)) {
                System.out.println(monthName + " " + year + " has 29 days");
            } else {
                System.out.println(monthName + " " + year + " has 28 days");
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println(monthName + " " + year + " has 30 days");
        } else if (month >= 1 && month <= 12) {
            System.out.println(monthName + " " + year + " has 31 days");
        } else {
            System.out.println("Invalid month");
        }
    }

    public static String MonthName(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Invalid Month";
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
