package diettelStringsAndCharacters;

import java.util.Scanner;

public class WordsEndingWithED {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine().toLowerCase();
        scanner.close();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.endsWith("ed")) {
                System.out.println(word);
            }
        }
    }
}
