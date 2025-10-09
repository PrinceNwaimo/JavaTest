package diettelStreams;

import java.util.ArrayList;
import java.util.Scanner;

public class MappingIntGradesToLetterGrades {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter grade (-1 to stop): ");
            int grade = scanner.nextInt();

            if (grade == -1) {
                break;
            }

            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            grades.stream()
                    .map(MappingIntGradesToLetterGrades::getLetterGrade)
                    .forEach(System.out::println);
        }
    }

    public static String getLetterGrade(int grade) {
        if (grade >= 90) {
            return grade + ": A";
        } else if (grade >= 80) {
            return grade + ": B";
        } else if (grade >= 70) {
            return grade + ": C";
        } else if (grade >= 60) {
            return grade + ": D";
        } else {
            return grade + ": F";
        }
    }
}
