package joyceInheritance;

public abstract class Student2 {
    protected int studentID;
    protected String lastName;
    protected double annualTuition;

    public Student2(int studentID, String lastName) {
        this.studentID = studentID;
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAnnualTuition() {
        return annualTuition;
    }

    public abstract void setAnnualTuition();
}
