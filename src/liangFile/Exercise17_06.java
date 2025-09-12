package liangFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exercise17_06 {
    public static void main(String[] args) {
        String filename = "Exercise17_06.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Loan[] loans = new Loan[5];
            loans[0] = new Loan(5, 5, 10000);
            loans[1] = new Loan(4.5, 10, 20000);
            loans[2] = new Loan(6, 7, 30000);
            loans[3] = new Loan(5.5, 3, 40000);
            loans[4] = new Loan(4, 8, 50000);

            for (Loan loan : loans) {
                oos.writeObject(loan);
            }
            System.out.println("Loans stored in file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
