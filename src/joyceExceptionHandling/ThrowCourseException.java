package joyceExceptionHandling;

public class ThrowCourseException {
    public static void main(String[] args) {
        Course[] courses = new Course[6];
        try {
            courses[0] = new Course("CIS", 101, 3);
            System.out.println("Course created successfully: " + courses[0]);
        } catch (CourseException e) {
            System.out.println("Error creating course: " + e.getMessage());
        }

        try {
            courses[1] = new Course("CI", 101, 3);
            System.out.println("Course created successfully: " + courses[1]);
        } catch (CourseException e) {
            System.out.println("Error creating course: " + e.getMessage());
        }

        try {
            courses[2] = new Course("CIS", 50, 3);
            System.out.println("Course created successfully: " + courses[2]);
        } catch (CourseException e) {
            System.out.println("Error creating course: " + e.getMessage());
        }

        try {
            courses[3] = new Course("CIS", 101, 7);
            System.out.println("Course created successfully: " + courses[3]);
        } catch (CourseException e) {
            System.out.println("Error creating course: " + e.getMessage());
        }

        try {
            courses[4] = new Course("MAT", 201, 4);
            System.out.println("Course created successfully: " + courses[4]);
        } catch (CourseException e) {
            System.out.println("Error creating course: " + e.getMessage());
        }

        try {
            courses[5] = new Course("SCI", 301, 3);
            System.out.println("Course created successfully: " + courses[5]);
        } catch (CourseException e) {
            System.out.println("Error creating course: " + e.getMessage());
        }
    }
}
