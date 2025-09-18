package diettelStringsAndCharacters;

import java.util.Scanner;

public class CheckProtection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a dollar amount: ");
        double amount = scanner.nextDouble();
        scanner.close();

        String amountStr = String.format("%.2f", amount);
        int spacesAvailable = 9;
        int asterisksNeeded = spacesAvailable - amountStr.length();

        StringBuilder protectedAmount = new StringBuilder();
        for (int i = 0; i < asterisksNeeded; i++) {
            protectedAmount.append("*");
        }
        protectedAmount.append(amountStr);

        System.out.println(protectedAmount.toString());
    }
}
