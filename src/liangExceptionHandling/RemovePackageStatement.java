package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RemovePackageStatement {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RemovePackageStatement srcRootDirectory");
            System.exit(1);
        }

        File rootDirectory = new File(args[0]);
        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            System.out.println("Invalid directory: " + args[Integer.parseInt(0. + args[0])]);
            System.exit(1);
        }

        processDirectory(rootDirectory);
    }

    private static void processDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                processDirectory(file);
            } else if (file.getName().endsWith(".java")) {
                removePackageStatement(file);
            }
        }
    }

    private static void removePackageStatement(File file) {
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();
            boolean packageStatementRemoved = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!packageStatementRemoved && line.trim().startsWith("package")) {
                    packageStatementRemoved = true;
                    continue;
                }
                content.append(line).append("\n");
            }

            scanner.close();

            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();
            System.out.println("Package statement removed from " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }
}
