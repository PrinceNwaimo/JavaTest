package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SavedCustomerList {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + " " + fields[2] + ", Balance: " + fields[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
