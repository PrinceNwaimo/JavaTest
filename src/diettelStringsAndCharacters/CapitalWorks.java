package diettelStringsAndCharacters;

import java.util.Scanner;

public class CapitalWorks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();
        scanner.close();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0))) {
                System.out.println(word);
            }
        }
    }
}
