package characterAndStrings;

import java.util.Scanner;

public class CountSpaces2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your favorite inspirational quote:");
        String quote = scanner.nextLine();

        int spaceCount = 0;

        for (char c : quote.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        System.out.println("Quote: " + quote);
        System.out.println("Total number of spaces: " + spaceCount);

        scanner.close();
    }
}
