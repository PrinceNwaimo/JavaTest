package joyceFiles;

import java.io.File;
import java.util.Scanner;

public class CompareFolders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path to the first file: ");
        String file1Path = scanner.nextLine();

        System.out.print("Enter the path to the second file: ");
        String file2Path = scanner.nextLine();

        System.out.print("Enter the path to the third file: ");
        String file3Path = scanner.nextLine();

        scanner.close();

        File file1 = new File(file1Path);
        File file2 = new File(file2Path);
        File file3 = new File(file3Path);

        if (file1.exists() && file2.exists() && file3.exists()) {
            String folder3 = file3.getParent();

            if (file1.getParent().equals(folder3) && file2.getParent().equals(folder3)) {
                System.out.println("Both files are located in the same folder as the third file.");
            } else {
                System.out.println("The files are not located in the same folder as the third file.");
                if (!file1.getParent().equals(folder3)) {
                    System.out.println("File 1 is located in " + file1.getParent());
                }
                if (!file2.getParent().equals(folder3)) {
                    System.out.println("File 2 is located in " + file2.getParent());
                }
            }
        } else {
            System.out.println("One or more files do not exist.");
        }
    }
}
