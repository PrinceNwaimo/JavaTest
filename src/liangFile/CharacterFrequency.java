package liangFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            int[] frequency = new int[256]; // Assuming ASCII

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                for (char c : line.toCharArray()) {
                    frequency[(int) c]++;
                }
            }

            fileScanner.close();

            System.out.println("Character Frequency:");
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] > 0) {
                    if (i >= 32 && i <= 126) { // Printable ASCII characters
                        System.out.println("'" + (char) i + "': " + frequency[i]);
                    } else {
                        System.out.println("ASCII " + i + ": " + frequency[i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        scanner.close();
    }
}
