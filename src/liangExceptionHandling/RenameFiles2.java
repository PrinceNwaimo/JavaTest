package liangExceptionHandling;

import java.io.File;

public class RenameFiles2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java RenameFiles *");
            System.exit(1);
        }

        for (String filename : args) {
            File file = new File(filename);
            if (file.isFile()) {
                renameFile(file);
            }
        }
    }

    private static void renameFile(File file) {
        String filename = file.getName();
        if (filename.matches("Exercise\\d+_\\d(?![\\d]).*")) {
            String newFilename = filename.replaceFirst("(\\d)($|\\.)", "0$1$2");
            File newFile = new File(file.getParent(), newFilename);
            if (file.renameTo(newFile)) {
                System.out.println("Renamed file: " + filename + " to " + newFilename);
            } else {
                System.out.println("Error renaming file: " + filename);
            }
        }
    }
}
