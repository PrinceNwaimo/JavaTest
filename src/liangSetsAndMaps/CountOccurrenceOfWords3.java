package liangSetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurrenceOfWords3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CountOccurrenceOfWords filename");
            System.exit(1);
        }

        Map<String, Integer> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
