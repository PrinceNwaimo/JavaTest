package liangFile;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class File2 {
    public static void main(String[] args) {
        String filename = "Exercise17_02.dat";
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(filename, true))) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                output.writeInt(random.nextInt(1000));
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
