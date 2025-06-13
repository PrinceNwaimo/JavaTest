package liangChapter6;

import java.util.Scanner;

public class PrintCalendar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        scanner.close();

        printMonth(year, month);
    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        System.out.println("         " + getMonthName(month) + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");
    }

    public static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }

    public static void printMonthBody(int year, int month) {
        int startDay = getStartDay(year, month);
        int daysInMonth = getDaysInMonth(year, month);

        for (int i = 0; i < startDay; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static int getStartDay(int year, int month) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int q = 1;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = (q + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;
        if (h < 0) {
            h += 7;
        }
        return h;
    }

    public static int getDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return isLeapYear(year) ? 29 : 28;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
