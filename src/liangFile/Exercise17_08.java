package liangFile;

import java.io.*;

public class Exercise17_08 {
    public static void main(String[] args) {
        String filename = "Exercise17_08.dat";
        int count = 0;

        // Read count from file
        File file = new File(filename);
        if (file.exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                count = dis.readInt();
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
        }

        // Increase count by 1
        count++;

        // Write count to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(count);
            System.out.println("This program has been executed " + count + " times.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
