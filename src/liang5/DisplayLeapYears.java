package liang5;

public class DisplayLeapYears {
    public static void main(String[] args) {
        int leapYearCount = 0; // Counter for leap years

        System.out.println("Leap years from 101 to 2100:");

        for (int year = 101; year <= 2100; year++) {
            // Check if the year is a leap year
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.printf("%d ", year); // Print the leap year
                leapYearCount++; // Increment the counter

                // Print a newline after every 10 leap years
                if (leapYearCount % 10 == 0) {
                    System.out.println();
                }
            }
        }

        // Print total number of leap years
        System.out.printf("%nTotal leap years: %d\n", leapYearCount);
    }
}
