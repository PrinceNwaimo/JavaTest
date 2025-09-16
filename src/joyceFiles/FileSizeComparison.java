package joyceFiles;

import java.io.File;

public class FileSizeComparison {
    public static void main(String[] args) {
        // Specify the paths to the two files
        String file1Path = "path_to_your_text_file.txt"; // e.g., Notepad file
        String file2Path = "path_to_your_word_file.docx"; // e.g., Word file

        File file1 = new File(file1Path);
        File file2 = new File(file2Path);

        if (file1.exists() && file2.exists()) {
            long file1Size = file1.length();
            long file2Size = file2.length();

            System.out.println("File 1 size: " + file1Size + " bytes");
            System.out.println("File 2 size: " + file2Size + " bytes");

            if (file1Size > 0 && file2Size > 0) {
                double sizeRatio = (double) file2Size / file1Size;
                System.out.printf("File 2 is %.2f times larger than File 1.%n", sizeRatio);
            } else {
                System.out.println("Cannot calculate size ratio because one of the files is empty.");
            }
        } else {
            System.out.println("One or both files do not exist.");
        }
    }
}
