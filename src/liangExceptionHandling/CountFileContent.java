package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountFileContent {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CountFileContent filename");
            System.exit(1);
        }

        String filename = args[0];
        File file = new File(filename);

        try {
            Scanner scanner = new Scanner(file);
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                charCount += line.length() + 1; // +1 for newline character
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            scanner.close();

            System.out.println("File: " + filename);
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
