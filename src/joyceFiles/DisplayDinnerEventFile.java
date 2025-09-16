package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayDinnerEventFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("dinner_events.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                System.out.println("Event Number: " + fields[0]);
                System.out.println("Event Type Code: " + fields[1]);
                System.out.println("Number of Guests: " + fields[2]);
                System.out.println("Price: " + fields[3]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
