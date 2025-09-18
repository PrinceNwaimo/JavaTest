package diettelFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class TelephoneNumberWordGenerator {
    private static final String[] letters = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        String phoneNumber = "425-3688";
        phoneNumber = phoneNumber.replace("-", "");
        generateWords(phoneNumber);
    }

    private static void generateWords(String phoneNumber) {
        try (Formatter formatter = new Formatter("words.txt")) {
            generateWordsRecursive(phoneNumber, 0, new StringBuilder());
        } catch (IOException e) {
            System.err.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    private static void generateWordsRecursive(String phoneNumber, int index, StringBuilder word) {
        if (index == phoneNumber.length()) {
            System.out.println(word.toString());
            try (Formatter formatter = new Formatter(new FileWriter("words.txt", true))) {
                formatter.format("%s%n", word.toString());
            } catch (IOException e) {
                System.err.println("Error writing to file.");
                e.printStackTrace();
            }
        } else {
            String letterSet = letters[Character.getNumericValue(phoneNumber.charAt(index))];
            for (int i = 0; i < letterSet.length(); i++) {
                word.append(letterSet.charAt(i));
                generateWordsRecursive(phoneNumber, index + 1, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}
