package diettelStringsAndCharacters;

import java.util.Scanner;

public class TokenizingTelephoneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a telephone number in the form (555) 555-5555: ");
        String phoneNumber = scanner.nextLine();
        scanner.close();

        // Remove parentheses
        String[] parts = phoneNumber.replace("(", "").replace(")", "").split("\\s+|-");

        String areaCode = parts[0];
        String phone = parts[1] + parts[2];

        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + phone);
    }
}
