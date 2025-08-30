package joyceInheritance;

import javax.swing.*;

public class CollegeList {
    public static void main(String[] args) {
        CollegeEmployee[] collegeEmployees = new CollegeEmployee[4];
        Faculty[] faculties = new Faculty[3];
        Student[] students = new Student[7];

        int collegeEmployeeIndex = 0;
        int facultyIndex = 0;
        int studentIndex = 0;

        while (true) {
            String choice = JOptionPane.showInputDialog("Enter type of person (C, F, S) or Q to quit");
            if (choice.equalsIgnoreCase("Q")) {
                break;
            }

            if (choice.equalsIgnoreCase("C")) {
                if (collegeEmployeeIndex < collegeEmployees.length) {
                    collegeEmployees[collegeEmployeeIndex] = new CollegeEmployee();
                    collegeEmployees[collegeEmployeeIndex].setData();
                    collegeEmployeeIndex++;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot add more college employees");
                }
            } else if (choice.equalsIgnoreCase("F")) {
                if (facultyIndex < faculties.length) {
                    faculties[facultyIndex] = new Faculty();
                    faculties[facultyIndex].setData();
                    facultyIndex++;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot add more faculty members");
                }
            } else if (choice.equalsIgnoreCase("S")) {
                if (studentIndex < students.length) {
                    students[studentIndex] = new Student();
                    students[studentIndex].setData();
                    studentIndex++;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot add more students");
                }
            }
        }

        System.out.println("College Employees:");
        if (collegeEmployeeIndex == 0) {
            System.out.println("No college employees added");
        } else {
            for (int i = 0; i < collegeEmployeeIndex; i++) {
                collegeEmployees[i].display();
                System.out.println(); // added to separate each employee's data
            }
        }

        System.out.println("\nFaculty:");
        if (facultyIndex == 0) {
            System.out.println("No faculty members added");
        } else {
            for (int i = 0; i < facultyIndex; i++) {
                faculties[i].display();
                System.out.println(); // added to separate each faculty member's data
            }
        }

        System.out.println("\nStudents:");
        if (studentIndex == 0) {
            System.out.println("No students added");
        } else {
            for (int i = 0; i < studentIndex; i++) {
                students[i].display();
                System.out.println(); // added to separate each student's data
            }
        }
    }
}
