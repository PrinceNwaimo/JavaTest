package diettel5;

import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variables to store the count of each grade
        int countA = 0, countB = 0, countC = 0, countD = 0;

        // Loop to input the grades of 5 students
        for (int i = 1; i <= 5; i++) {
            // Input student name
            System.out.printf("Enter name for Student %d: ", i);
            String studentName = input.nextLine();

            // Input student grade
            System.out.printf("Enter grade for %s (A/B/C/D): ", studentName);
            char grade = input.next().charAt(0); // Reads the first character as grade
            input.nextLine(); // Consume the newline character after the grade input

            // Switch to determine the grade count
            switch (grade) {
                case 'A':
                case 'a':
                    countA++;
                    break;
                case 'B':
                case 'b':
                    countB++;
                    break;
                case 'C':
                case 'c':
                    countC++;
                    break;
                case 'D':
                case 'd':
                    countD++;
                    break;
                default:
                    System.out.println("Invalid grade entered. Please enter A, B, C, or D.");
                    i--; // Repeat this iteration since an invalid grade was entered
                    break;
            }
        }

        // Display the results
        System.out.println("\nGrade Summary:");
        System.out.printf("Number of students with grade A: %d%n", countA);
        System.out.printf("Number of students with grade B: %d%n", countB);
        System.out.printf("Number of students with grade C: %d%n", countC);
        System.out.printf("Number of students with grade D: %d%n", countD);

        input.close();
    }
}
