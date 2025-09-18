package diettelStringsAndCharacters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateFormatConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (MM/dd/yyyy): ");
        String dateStr = scanner.nextLine();
        scanner.close();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        try {
            LocalDate date = LocalDate.parse(dateStr, inputFormatter);
            String formattedDate = date.format(outputFormatter);
            System.out.println(formattedDate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use MM/dd/yyyy.");
        }
    }
}
