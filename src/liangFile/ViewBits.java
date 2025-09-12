package liangFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ViewBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String filename = scanner.nextLine();

        try (FileInputStream fis = new FileInputStream(filename)) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                System.out.println("Byte: " + byteRead + ", Binary representation: " + getBits(byteRead));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static String getBits(int value) {
        StringBuilder bits = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            bits.append((value >> i) & 1);
        }
        return bits.toString();
    }
}
