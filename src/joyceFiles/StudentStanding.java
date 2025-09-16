package joyceFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentStanding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter goodStanding = new PrintWriter(new FileWriter("good_standing.txt", true));
             PrintWriter probation = new PrintWriter(new FileWriter("probation.txt", true))) {

            while (true) {
                System.out.print("Enter ID number: ");
                String id = scanner.nextLine();
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter grade point average: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                if (gpa >= 2.0) {
                    goodStanding.println(id + "," + firstName + "," + lastName + "," + gpa);
                } else {
                    probation.println(id + "," + firstName + "," + lastName + "," + gpa);
                }

                System.out.print("Do you want to add another record? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
}
