package liangChapter9;

import java.util.GregorianCalendar;

public class Calendar {
    public static void main(String[] args) {
        // Display current year, month, and day
        GregorianCalendar currentCalendar = new GregorianCalendar();
        System.out.println("Current Date:");
        System.out.println("Year: " + currentCalendar.get(GregorianCalendar.YEAR));
        System.out.println("Month: " + (currentCalendar.get(GregorianCalendar.MONTH) + 1)); // Months are 0-based
        System.out.println("Day: " + currentCalendar.get(GregorianCalendar.DAY_OF_MONTH));

        // Set elapsed time and display year, month, and day
        GregorianCalendar specifiedCalendar = new GregorianCalendar();
        specifiedCalendar.setTimeInMillis(1234567898765L);
        System.out.println("\nDate for elapsed time 1234567898765L:");
        System.out.println("Year: " + specifiedCalendar.get(GregorianCalendar.YEAR));
        System.out.println("Month: " + (specifiedCalendar.get(GregorianCalendar.MONTH) + 1)); // Months are 0-based
        System.out.println("Day: " + specifiedCalendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
