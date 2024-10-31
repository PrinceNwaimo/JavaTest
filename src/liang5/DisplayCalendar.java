package liang5;

    import java.util.Scanner;

    public class DisplayCalendar {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt user for input
            System.out.print("Enter a year: ");
            int year = scanner.nextInt();
            System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, ..., 6 for Saturday): ");
            int firstDayOfYear = scanner.nextInt();

            // Days in each month
            int[] daysInMonth = {
                    31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30,
                    31, 31, 30, 31, 30, 31
            };

            // Month names
            String[] months = {
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            };

            // Display calendar for each month
            for (int month = 0; month < 12; month++) {
                System.out.printf("%n%s %d%n", months[month], year);
                System.out.println("Sun Mon Tue Wed Thu Fri Sat");

                // Print leading spaces
                for (int i = 0; i < firstDayOfYear; i++) {
                    System.out.print("    ");
                }

                // Print days of the month
                for (int day = 1; day <= daysInMonth[month]; day++) {
                    System.out.printf("%-3d", day);

                    // Move to the next line after Saturday
                    if ((firstDayOfYear + day) % 7 == 0) {
                        System.out.println();
                    }
                }

                // Update the first day of the next month
                firstDayOfYear = (firstDayOfYear + daysInMonth[month]) % 7;
                System.out.println(); // Move to the next line after printing a month
            }
        }

        // Method to check if the year is a leap year
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }


