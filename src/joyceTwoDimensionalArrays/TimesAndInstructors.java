package joyceTwoDimensionalArrays;

import java.util.Scanner;

public class TimesAndInstructors {
    public static void main(String[] args) {
        String[][] courses = {
                {"CIS101", "Mon 9 am", "Johnson"},
                {"CIS102", "Tue 10 am", "Smith"},
                {"MAT101", "Wed 11 am", "Williams"},
                {"CIS101", "Thu 2 pm", "Johnson"},
                {"ENG101", "Fri 9 am", "Davis"}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a course name: ");
        String courseName = scanner.nextLine();

        boolean courseFound = false;
        for (String[] course : courses) {
            if (course[0].equals(courseName)) {
                System.out.println("Course: " + course[0] + ", Time: " + course[1] + ", Instructor: " + course[2]);
                courseFound = true;
            }
        }

        if (!courseFound) {
            System.out.println("Course not found");
        }
    }

}
