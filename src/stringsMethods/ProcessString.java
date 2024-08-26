package stringsMethods;

import java.util.Scanner;

public class ProcessString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.length() > 0) {
            System.out.println("Length: " + input.length());
            System.out.println("First character: " + input.charAt(0));
        } else {
            System.out.println("Please enter a non-empty string.");
        }
    }

}
