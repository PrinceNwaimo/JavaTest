package diettelStringsAndCharacters;

import java.util.Scanner;

public class MorseCodeEncoder {
    private static final String[] morseCode = {
            ".-",   // A
            "-...", // B
            "-.-.", // C
            "-..",  // D
            ".",    // E
            "..-.", // F
            "--.",  // G
            "....", // H
            "..",   // I
            ".---", // J
            "-.-",  // K
            ".-..", // L
            "--",   // M
            "-.",   // N
            "---",  // O
            ".--.", // P
            "--.-", // Q
            ".-.",  // R
            "...",  // S
            "-",    // T
            "..-",  // U
            "...-", // V
            ".--",  // W
            "-..-", // X
            "-.--", // Y
            "--.."  // Z
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = scanner.nextLine().toUpperCase();
        scanner.close();

        StringBuilder morseCodeStr = new StringBuilder();

        for (String word : phrase.split("\\s+")) {
            for (char c : word.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    morseCodeStr.append(morseCode[c - 'A']).append(" ");
                }
            }
            morseCodeStr.append("   "); // Three spaces between words
        }

        System.out.println(morseCodeStr.toString().trim());
    }
}
