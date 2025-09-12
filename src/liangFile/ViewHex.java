package liangFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ViewHex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String filename = scanner.nextLine();

        try (FileInputStream fis = new FileInputStream(filename)) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                System.out.print(String.format("%02X ", byteRead));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
