package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReplaceWords {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java ReplaceWords *");
            System.exit(1);
        }

        for (String filename : args) {
            File file = new File(filename);
            if (file.isFile()) {
                replaceWordsInFile(file);
            }
        }
    }

    private static void replaceWordsInFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(replaceWordsInLine(line)).append("\n");
            }

            scanner.close();

            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();
            System.out.println("Replaced words in file: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }

    private static String replaceWordsInLine(String line) {
        return line.replaceAll("Exercise(\\d)_(\\d)", "Exercise0$1_0$2")
                .replaceAll("Exercise(\\d)_(\\d\\d)", "Exercise0$1_$2")
                .replaceAll("Exercise(\\d\\d)_(\\d)", "Exercise$1_0$2");
    }
}
