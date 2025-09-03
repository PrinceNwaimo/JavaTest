package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalculateScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            double total = 0;
            int count = 0;

            while (fileScanner.hasNextDouble()) {
                total += fileScanner.nextDouble();
                count++;
            }

            fileScanner.close();

            if (count == 0) {
                System.out.println("No scores found in the file.");
            } else {
                double average = total / count;
                System.out.println("Total: " + total);
                System.out.println("Average: " + average);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
