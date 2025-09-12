package liangFile;

import java.io.*;

public class Exercise17_04 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Exercise17_04 sourceFile targetFile");
            System.exit(1);
        }

        String sourceFile = args[0];
        String targetFile = args[1];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
             DataOutputStream output = new DataOutputStream(new FileOutputStream(targetFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                output.writeUTF(line);
            }
        }

        File source = new File(sourceFile);
        File target = new File(targetFile);

        System.out.println("Size of source file: " + source.length() + " bytes");
        System.out.println("Size of target file: " + target.length() + " bytes");
    }
}
