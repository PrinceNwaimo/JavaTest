package diettelStringsAndCharacters;

import java.util.Scanner;

public class ThreeLetterStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a five-letter word: ");
        String word = scanner.nextLine().toLowerCase();
        scanner.close();

        if (word.length() != 5) {
            System.out.println("Please enter a five-letter word.");
            return;
        }

        generateThreeLetterStrings(word);
    }

    public static void generateThreeLetterStrings(String word) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == i) continue;
                for (int k = 0; k < 5; k++) {
                    if (k == i || k == j) continue;
                    String threeLetterString = "" + word.charAt(i) + word.charAt(j) + word.charAt(k);
                    System.out.println(threeLetterString);
                }
            }
        }
    }
}
