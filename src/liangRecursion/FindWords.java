package liangRecursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindWords {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FindWords dirName word");
            System.exit(1);
        }

        String dirName = args[0];
        String word = args[1].toLowerCase();

        File dir = new File(dirName);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory");
            System.exit(1);
        }

        findWords(dir, word);
    }

    private static void findWords(File dir, String word) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    findWordInFile(file, word);
                } else if (file.isDirectory()) {
                    findWords(file, word);
                }
            }
        }
    }

    private static void findWordInFile(File file, String word) {
        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                if (line.contains(word)) {
                    System.out.println("Found '" + word + "' in file " + file.getAbsolutePath() + " at line " + lineNumber);
                }
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + file.getAbsolutePath());
        }
    }
}
