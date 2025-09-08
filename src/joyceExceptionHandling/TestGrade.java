package joyceExceptionHandling;

import java.util.Scanner;

public class TestGrade {
    public static void main(String[] args) {
        String[] studentIds = {"S001", "S002", "S003", "S004", "S005", "S006", "S007", "S008"};
        String[] grades = new String[studentIds.length];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < studentIds.length; i++) {
            try {
                System.out.print("Enter grade for student " + studentIds[i] + ": ");
                String grade = scanner.next().toUpperCase();
                if (!GradeException.isValidGrade(grade)) {
                    throw new GradeException("Invalid grade. Grade should be A, B, C, D, F, or I.");
                }
                grades[i] = grade;
            } catch (GradeException e) {
                System.out.println(e.getMessage());
                grades[i] = "I";
            }
        }

        System.out.println("\nStudent IDs and Grades:");
        for (int i = 0; i < studentIds.length; i++) {
            System.out.println(studentIds[i] + ": " + grades[i]);
        }
    }
}
