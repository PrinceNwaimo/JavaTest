package liangRecursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReplaceWords {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java ReplaceWords dirName oldWord newWord");
            System.exit(1);
        }

        String dirName = args[0];
        String oldWord = args[1];
        String newWord = args[2];

        File dir = new File(dirName);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory");
            System.exit(1);
        }

        replaceWords(dir, oldWord, newWord);
    }

    private static void replaceWords(File dir, String oldWord, String newWord) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    replaceWordInFile(file, oldWord, newWord);
                } else if (file.isDirectory()) {
                    replaceWords(file, oldWord, newWord);
                }
            }
        }
    }

    private static void replaceWordInFile(File file, String oldWord, String newWord) {
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().replaceAll(oldWord, newWord);
                content.append(line).append(System.lineSeparator());
            }
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content.toString());
                System.out.println("Replaced words in file " + file.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file " + file.getAbsolutePath());
        }
    }
}
