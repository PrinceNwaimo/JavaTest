package joyceFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo5 {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Java\\Chapter.13\\Data.txt");
        try {
            BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Creation time " + attr.creationTime());
            System.out.println("Last modified time " +
                    attr.lastModifiedTime());
            System.out.println("Size " + attr.size());
        } catch (IOException e) {
            System.out.println("IO Exception");

        }
    }
}