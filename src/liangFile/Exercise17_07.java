package liangFile;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exercise17_07 {
    public static void main(String[] args) {
        String filename = "Exercise17_06.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            double totalAmount = 0;
            while (true) {
                try {
                    Loan loan = (Loan) ois.readObject();
                    totalAmount += loan.getLoanAmount();
                } catch (EOFException e) {
                    break; // End of file reached
                } catch (ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println("Total loan amount: " + totalAmount);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
