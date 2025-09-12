package liangFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class File1 {
    public static void main(String[] args) {
        String filename = "Exercise17_01.txt";
        try (PrintWriter output = new PrintWriter(new FileWriter(filename, true))) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                output.print(random.nextInt(1000) + " ");
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
