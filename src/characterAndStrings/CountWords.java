package characterAndStrings;

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        long wordCount = input.replaceAll("[.,;?!-]", " ").trim().split("\\s+").length;

        System.out.println("Number of words: " + wordCount);

        scanner.close();
    }

}
