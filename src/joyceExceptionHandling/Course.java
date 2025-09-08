package joyceExceptionHandling;

public class Course {
    private String department;
    private int courseNumber;
    private double credits;

    public Course(String department, int courseNumber, double credits) throws CourseException {
        if (department.length() != 3 || !department.matches("[a-zA-Z]+")) {
            throw new CourseException("Invalid department. Department should be 3 letters.");
        }
        if (courseNumber < 100 || courseNumber > 499) {
            throw new CourseException("Invalid course number. Course number should be between 100 and 499.");
        }
        if (credits < 0.5 || credits > 6) {
            throw new CourseException("Invalid credits. Credits should be between 0.5 and 6.");
        }
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return department + " " + courseNumber + ": " + credits + " credits";
    }
}
