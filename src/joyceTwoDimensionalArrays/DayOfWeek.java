package joyceTwoDimensionalArrays;

import java.util.Scanner;

public class DayOfWeek {
    public enum Days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    }



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a day (SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY): ");
            String dayName = scanner.nextLine().toUpperCase();

            try {
                Days day = Days.valueOf(dayName);
                System.out.println("Business hours for " + day + ": " + getBusinessHours(day));
                System.out.println(day + " - " + getBusinessHours(day));

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid day");

            }
        }

        private static String getBusinessHours(Days day) {
            switch (day) {
                case SUNDAY:
                    return "11am - 5pm";
                case SATURDAY:
                    return "10am - 6pm";
                default:
                    return "9am - 9pm";
            }
        }
    }

