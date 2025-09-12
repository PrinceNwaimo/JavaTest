package liangFile;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Exercise17_03 {
    public static void main(String[] args) {
        String filename = "Exercise17_02.dat";
        try (DataInputStream input = new DataInputStream(new FileInputStream(filename))) {
            int sum = 0;
            while (true) {
                try {
                    sum += input.readInt();
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("The sum of the integers in the file is: " + sum);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
