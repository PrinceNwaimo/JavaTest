package stringsMethods;

import java.util.Scanner;

public class CheckSSN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Social Security number (DDD-DD-DDDD): ");
        String ssn = scanner.next();

        if (ssn.matches("\\d{3}-\\d{2}-\\d{4}")) {
            System.out.println("Valid Social Security number");
        } else {
            System.out.println("Invalid Social Security number. Please enter in the format DDD-DD-DDDD.");
        }
    }

}
