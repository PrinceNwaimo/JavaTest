package liangExceptionHandling;

import java.io.File;

public class RenameFiles {
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
        if (filename.matches("Exercise\\d_.*")) {
            String newFilename = filename.replaceFirst("Exercise(\\d)_", "Exercise0$1_");
            File newFile = new File(file.getParent(), newFilename);
            if (file.renameTo(newFile)) {
                System.out.println("Renamed file: " + filename + " to " + newFilename);
            } else {
                System.out.println("Error renaming file: " + filename);
            }
        }
    }
}
