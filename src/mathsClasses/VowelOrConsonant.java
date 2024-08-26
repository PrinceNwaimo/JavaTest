package mathsClasses;

import java.util.Scanner;

public class VowelOrConsonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        String input = scanner.next().toLowerCase();

        if (input.length() == 1) {
            char letter = input.charAt(0);

            if ("aeiou".indexOf(letter) != -1) {
                System.out.println(letter + " is a vowel.");
            } else if ("bcdfghjklmnpqrstvwxyz".indexOf(letter) != -1) {
                System.out.println(letter + " is a consonant.");
            } else {
                System.out.println(letter + " is not a letter.");
            }
        } else {
            System.out.println("Please enter a single letter.");
        }
    }

}
