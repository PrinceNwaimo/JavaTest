package characterAndStrings;

import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word:");
        String word = scanner.nextLine();

        String pigLatin = convertToPigLatin(word);

        System.out.println("The Pig Latin version is: " + pigLatin);

        scanner.close();
    }

    public static String convertToPigLatin(String word) {
        String vowels = "aeiou";
        int index = 0;

        // Check if the word starts with a vowel
        if (vowels.indexOf(word.charAt(0)) != -1) {
            return word + "ay";
        }

        // Find the index of the first vowel
        while (index < word.length() && vowels.indexOf(word.charAt(index)) == -1) {
            index++;
        }

        // Move all consonants before the first vowel to the end and add "ay"
        return word.substring(index) + word.substring(0, index) + "ay";
    }

}
