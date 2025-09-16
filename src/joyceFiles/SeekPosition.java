package joyceFiles;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class SeekPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
        System.out.print("Enter file position: ");
        long position = scanner.nextLong();
        scanner.close();

        try (RandomAccessFile file = new RandomAccessFile(new File(filename), "r")) {
            if (position < file.length()) {
                file.seek(position);
                byte[] buffer = new byte[10];
                int bytesRead = file.read(buffer);
                System.out.println("Next 10 characters: " + new String(buffer, 0, bytesRead));
            } else {
                System.out.println("Position exceeds file length.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
