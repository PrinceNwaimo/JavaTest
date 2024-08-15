package chapterThree;

import java.util.Scanner;

public class ZellersCongruence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        System.out.print("Enter month (3-14): ");
        int month = scanner.nextInt();

        System.out.print("Enter day of the month: ");
        int day = scanner.nextInt();

        int century = year / 100;
        int yearOfCentury = year % 100;

        int h = (day + 26 * (month + 1) / 10 + yearOfCentury + yearOfCentury / 4 + century / 4 + 5 * century) % 7;

        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println("Day of the week: " + days[h]);
    }

}
