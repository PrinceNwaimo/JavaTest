package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            int[] letterCounts = new int[26];

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().toLowerCase();
                for (char c : line.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        letterCounts[c - 'a']++;
                    }
                }
            }

            fileScanner.close();

            for (int i = 0; i < 26; i++) {
                System.out.println("Number of " + (char)('A' + i) + "'s: " + letterCounts[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

}
