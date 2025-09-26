package liangSetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NonDuplicateWords {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java NonDuplicateWords filename");
            System.exit(1);
        }

        Set<String> words = new TreeSet<>();

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1);
        }

        System.out.println("Nonduplicate words in ascending order:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
