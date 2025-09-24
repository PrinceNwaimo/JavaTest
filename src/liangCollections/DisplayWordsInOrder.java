package liangCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DisplayWordsInOrder {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DisplayWordsInOrder <filename>");
            System.exit(1);
        }

        String filename = args[0];
        List<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (word.matches("[a-zA-Z]+.*")) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.exit(1);
        }

        Collections.sort(words);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
