package diettelStringsAndCharacters;

import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        String[] words = sentence.split("\\s+");

        for (String word : words) {
            printLatinWord(word);
            System.out.print(" ");
        }
    }

    public static void printLatinWord(String word) {
        System.out.print(word.substring(1) + word.charAt(0) + "ay");
    }
}
