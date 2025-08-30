package joyceInheritance;

import java.util.Scanner;

public class UseCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter department: ");
        String department = scanner.nextLine().toUpperCase();
        System.out.print("Enter course number: ");
        int courseNumber = scanner.nextInt();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();

        CollegeCourse course;
        if (department.equals("BIO") || department.equals("CHM") || department.equals("CIS") || department.equals("PHY")) {
            course = new LabCourse(department, courseNumber, credits);
        } else {
            course = new CollegeCourse(department, courseNumber, credits);
        }

        course.display();
        if (course instanceof LabCourse) {
            System.out.println("Total Fee including lab fee: $" + ((LabCourse) course).getTotalFee());
        }
    }
}
