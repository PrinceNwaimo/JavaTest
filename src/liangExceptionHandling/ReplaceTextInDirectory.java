package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReplaceTextInDirectory {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Exercise12_22 dir oldString newString");
            System.exit(1);
        }

        String directoryPath = args[0];
        String oldString = args[1];
        String newString = args[2];

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directoryPath);
            System.exit(1);
        }

        replaceTextInDirectory(directory, oldString, newString);
    }

    private static void replaceTextInDirectory(File directory, String oldString, String newString) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                replaceTextInDirectory(file, oldString, newString);
            } else {
                replaceTextInFile(file, oldString, newString);
            }
        }
    }

    private static void replaceTextInFile(File file, String oldString, String newString) {
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line.replaceAll(oldString, newString)).append("\n");
            }

            scanner.close();

            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();
            System.out.println("Replaced text in file: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }
}
