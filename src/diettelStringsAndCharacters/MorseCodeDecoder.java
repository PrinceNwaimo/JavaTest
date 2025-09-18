package diettelStringsAndCharacters;

import java.util.Scanner;

public class MorseCodeDecoder {
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
        System.out.print("Enter a Morse code phrase: ");
        String morseCodeStr = scanner.nextLine();
        scanner.close();

        StringBuilder decodedStr = new StringBuilder();

        for (String word : morseCodeStr.split("   ")) { // Three spaces between words
            for (String code : word.split("\\s+")) {
                for (int i = 0; i < morseCode.length; i++) {
                    if (morseCode[i].equals(code)) {
                        decodedStr.append((char) ('A' + i));
                        break;
                    }
                }
            }
            decodedStr.append(" ");
        }

        System.out.println(decodedStr.toString().trim());
    }
}
