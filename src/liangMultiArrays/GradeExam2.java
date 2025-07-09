package liangMultiArrays;

import java.util.Arrays;

public class GradeExam2 {
    public static void main(String[] args) {
        char[] answers = {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'};

        // Create a 2D array to store student IDs and their answers
        char[][] students = new char[5][10];

        // Initialize student IDs and their answers
        char studentId = '0';
        for (int i = 0; i < students.length; i++) {
            students[i][0] = studentId++;
            for (int j = 1; j < students[i].length; j++) {
                students[i][j] = (char) ('A' + (int) (Math.random() * 5));
            }
        }

        // Grade all students
        int[][] grades = new int[students.length][2];
        for (int i = 0; i < students.length; i++) {
            grades[i][0] = students[i][0];
            int correctCount = 0;
            for (int j = 1; j < students[i].length; j++) {
                if (students[i][j] == answers[j - 1]) {
                    correctCount++;
                }
            }
            grades[i][1] = correctCount;
        }

        // Sort grades in increasing order
        Arrays.sort(grades, (a, b) -> a[1] - b[1]);

        // Display the sorted grades
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Student " + (char) grades[i][0] + "'s correct count is " + grades[i][1]);
        }
    }

}
