package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddPackageStatement {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java AddPackageStatement srcRootDirectory");
            System.exit(1);
        }

        File rootDirectory = new File(args[0]);
        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            System.out.println("Invalid directory: " + args[0]);
            System.exit(1);
        }

        processDirectory(rootDirectory);
    }

    private static void processDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        String packageName = getPackageName(directory);
        for (File file : files) {
            if (file.isDirectory()) {
                processDirectory(file);
            } else if (file.getName().endsWith(".java")) {
                addPackageStatement(file, packageName);
            }
        }
    }

    private static String getPackageName(File directory) {
        String path = directory.getAbsolutePath();
        int index = path.lastIndexOf(File.separator);
        if (index == -1) {
            return "";
        }
        String packageName = path.substring(path.lastIndexOf(File.separator, index - 1) + 1);
        return packageName;
    }

    private static void addPackageStatement(File file, String packageName) {
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();
            boolean packageStatementAdded = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!packageStatementAdded && line.trim().startsWith("package")) {
                    packageStatementAdded = true;
                    content.append("package ").append(packageName).append(";\n");
                    content.append(line).append("\n");
                } else if (!packageStatementAdded && line.trim().startsWith("import")) {
                    content.insert(0, "package ").append(packageName).append(";\n\n");
                    packageStatementAdded = true;
                    content.append(line).append("\n");
                } else if (!packageStatementAdded && line.trim().startsWith("public")) {
                    content.insert(0, "package ").append(packageName).append(";\n\n");
                    packageStatementAdded = true;
                    content.append(line).append("\n");
                } else {
                    content.append(line).append("\n");
                }
            }

            if (!packageStatementAdded) {
                content.insert(0, "package ").append(packageName).append(";\n\n");
            }

            scanner.close();

            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();
            System.out.println("Package statement added to " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }
}
