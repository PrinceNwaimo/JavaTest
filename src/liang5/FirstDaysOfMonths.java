package liang5;
    import java.util.Scanner;

    public class FirstDaysOfMonths {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Month names
            String[] months = {
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            };

            // Days of the week
            String[] daysOfWeek = {
                    "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            };

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

            // Calculate and display the first day of each month
            for (int month = 0; month < 12; month++) {
                System.out.printf("%s 1, %d is %s%n", months[month], year, daysOfWeek[firstDayOfYear]);
                // Update the first day of the next month
                firstDayOfYear = (firstDayOfYear + daysInMonth[month]) % 7;
            }
        }

        // Method to check if the year is a leap year
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }


