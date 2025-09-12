package liangFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileDecryptor4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input file name (encrypted file): ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter output file name (unencrypted file): ");
        String outputFile = scanner.nextLine();

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write((byteRead - 5 + 256) % 256); // Ensure byte value is within 0-255 range
            }

            System.out.println("File decrypted and saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
