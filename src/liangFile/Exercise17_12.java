package liangFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_12 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Exercise17_12 SourceFile1 ... SourceFilen TargetFile");
            System.exit(1);
        }

        String targetFile = args[args.length - 1];
        String[] sourceFiles = new String[args.length - 1];
        System.arraycopy(args, 0, sourceFiles, 0, args.length - 1);

        try (FileOutputStream fos = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            for (String sourceFile : sourceFiles) {
                try (FileInputStream fis = new FileInputStream(sourceFile)) {
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Combined " + sourceFile);
            }
            System.out.println("Files combined into " + targetFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
