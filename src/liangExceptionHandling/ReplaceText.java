package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java ReplaceText filename oldString newString");
            System.exit(1);
        }

        String filename = args[0];
        String oldString = args[1];
        String newString = args[2];

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File " + filename + " does not exist.");
            System.exit(2);
        }

        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line.replaceAll(oldString, newString)).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.exit(2);
        }

        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print(sb.toString());
            writer.close();
            System.out.println("Replacement done.");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + filename);
            System.exit(2);
        }
    }
}
