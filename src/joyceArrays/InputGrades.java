package joyceArrays;

import java.util.Scanner;

public class InputGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[10];

        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter ID for student #" + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            students[i] = new Student(id);

            for (int j = 0; j < 5; j++) {
                System.out.print("Enter course ID #" + (j + 1) + " for student #" + (i + 1) + ": ");
                String courseId = scanner.nextLine();
                System.out.print("Enter credit hours for course #" + (j + 1) + " for student #" + (i + 1) + ": ");
                int creditHours = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                String grade = getGrade(scanner, i, j);

                CollegeCourse course = new CollegeCourse(courseId, creditHours, grade);
                students[i].setCourse(course, j);
            }
        }

        // Display entered data
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student ID: " + students[i].getId());
            for (int j = 0; j < 5; j++) {
                System.out.println(students[i].getCourse(j));
            }
            System.out.println();
        }

        scanner.close();
    }

    public static String getGrade(Scanner scanner, int studentIndex, int courseIndex) {
        while (true) {
            System.out.print("Enter grade (A, B, C, D, or F) for course #" + (courseIndex + 1) + " for student #" + (studentIndex + 1) + ": ");
            String grade = scanner.nextLine().toUpperCase();
            if (grade.matches("[ABCDIF]")) {
                return grade;
            }
            System.out.println("Invalid grade. Please enter A, B, C, D, or F.");
        }
    }

}
