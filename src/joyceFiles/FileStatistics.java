package joyceFiles;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Containing Folder: " + file.getParent());
            System.out.println("File Size: " + file.length() + " bytes");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Last Modified: " + sdf.format(new Date(file.lastModified())));
        } else {
            System.out.println("File not found.");
        }
    }
}
