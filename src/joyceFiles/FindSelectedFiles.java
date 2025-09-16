package joyceFiles;

import java.io.File;

public class FindSelectedFiles {
    public static void main(String[] args) {
        // Specify the folder path (current folder by default)
        String folderPath = System.getProperty("user.dir");

        // Specify the file names to search for
        String[] fileNames = {
                "autoexec.bat",
                "CompareFolders.java",
                "FileStatistics.class",
                "Hello.doc"
        };

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Searching for files in: " + folderPath);

            for (String fileName : fileNames) {
                File file = new File(folder, fileName);

                if (file.exists()) {
                    System.out.println(fileName + " is found in the folder.");
                } else {
                    System.out.println(fileName + " is not found in the folder.");
                }
            }
        } else {
            System.out.println("The specified folder does not exist or is not a directory.");
        }
    }
}
