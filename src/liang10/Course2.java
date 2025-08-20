package liang10;

import java.util.Arrays;

public class Course2 {
    private String courseName;
    private String[] students = new String[4];
    private int numberOfStudents;

    public Course2(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            students = Arrays.copyOf(students, students.length * 2);
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents() {
        return Arrays.copyOf(students, numberOfStudents);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.arraycopy(students, index + 1, students, index, numberOfStudents - index - 1);
            numberOfStudents--;
        }
    }

    public void clear() {
        numberOfStudents = 0;
    }

    public static void main(String[] args) {
        Course2 course = new Course2("Math");
        course.addStudent("John");
        course.addStudent("Mary");
        course.addStudent("Peter");

        System.out.println("Students in the course:");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }

        course.dropStudent("Mary");

        System.out.println("Students in the course after dropping Mary:");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }

        course.clear();

        System.out.println("Students in the course after clearing:");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }
    }
}
