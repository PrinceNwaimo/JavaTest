package joyceInheritance;

public class CollegeCourse {
    private String department;
    private int courseNumber;
    private int credits;
    private double fee;

    public CollegeCourse(String department, int courseNumber, int credits) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.fee = credits * 120;
    }

    public void display() {
        System.out.println("Department: " + department);
        System.out.println("Course Number: " + courseNumber);
        System.out.println("Credits: " + credits);
        System.out.println("Fee: $" + fee);
    }

    public String getDepartment() {
        return department;
    }

    public double getFee() {
        return fee;
    }
}
