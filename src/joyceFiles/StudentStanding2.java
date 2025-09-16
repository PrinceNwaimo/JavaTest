package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentStanding2 {
    public static void main(String[] args) {
        try (BufferedReader goodStanding = new BufferedReader(new FileReader("good_standing.txt"));
             BufferedReader probation = new BufferedReader(new FileReader("probation.txt"))) {

            System.out.println("Students in Good Standing:");
            String line;
            while ((line = goodStanding.readLine()) != null) {
                String[] fields = line.split(",");
                double gpa = Double.parseDouble(fields[3]);
                System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + " " + fields[2] + ", GPA: " + fields[3] + ", Above cutoff: " + (gpa - 2.0));
            }

            System.out.println("\nStudents on Academic Probation:");
            while ((line = probation.readLine()) != null) {
                String[] fields = line.split(",");
                double gpa = Double.parseDouble(fields[3]);
                System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + " " + fields[2] + ", GPA: " + fields[3] + ", Below cutoff: " + (2.0 - gpa));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
