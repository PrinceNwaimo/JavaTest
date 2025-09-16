package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayRentalFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("rentals.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                System.out.println("Contract Number: " + fields[0]);
                System.out.println("Rental Time: " + fields[1] + " hours " + fields[2] + " minutes");
                System.out.println("Equipment Type Code: " + fields[3]);
                System.out.println("Equipment Type Name: " + fields[4]);
                System.out.println("Price: " + fields[5]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
