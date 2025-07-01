package liangArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student " + (i + 1) + "'s name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student " + (i + 1) + "'s score: ");
            double score = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            students[i] = new Student(name, score);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getScore() > s2.getScore()) {
                    return -1;
                } else if (s1.getScore() < s2.getScore()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("Students in decreasing order of their scores:");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getScore());
        }
    }

}
