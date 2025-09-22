package liangRecursion;

import java.io.File;
import java.util.Scanner;

public class FileCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory: ");
        String directory = scanner.nextLine();
        scanner.close();

        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            int fileCount = countFiles(dir);
            System.out.println("Number of files in the directory: " + fileCount);
        } else {
            System.out.println("Invalid directory");
        }
    }

    private static int countFiles(File dir) {
        int count = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    count++;
                } else if (file.isDirectory()) {
                    count += countFiles(file);
                }
            }
        }
        return count;
    }
}
