package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class WriteReadData {
    public static void main(String[] args) {
        String filename = "Exercise12_15.txt";
        File file = new File(filename);

        // Write data to file
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + filename);
            }

            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < 100; i++) {
                writer.print((int) (Math.random() * 1000) + " ");
            }
            writer.close();
            System.out.println("Data written to file.");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read data from file and sort
        try {
            Scanner scanner = new Scanner(file);
            int[] numbers = new int[100];
            int i = 0;
            while (scanner.hasNextInt()) {
                numbers[i++] = scanner.nextInt();
            }
            scanner.close();

            Arrays.sort(numbers);
            System.out.println("Data read from file and sorted:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
