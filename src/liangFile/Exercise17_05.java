package liangFile;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Exercise17_05 {
//    public static void main(String[] args) {
//        String filename = "Exercise17_05.dat";
//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
//            int[] array = {1, 2, 3, 4, 5};
//            dos.writeInt(array.length);
//            for (int value : array) {
//                dos.writeInt(value);
//            }
//
//            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
//                oos.writeObject(new Date());
//                oos.writeDouble(5.5);
//            }
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        String filename = "Exercise17_05.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            int[] array = {1, 2, 3, 4, 5};
            oos.writeObject(array);
            oos.writeObject(new Date());
            oos.writeDouble(5.5);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
