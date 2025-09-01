package joyceInheritance;

public class UndergraduateStudent extends Student2{
    private static final double TUITION_PER_SEMESTER = 4000;

    public UndergraduateStudent(int studentID, String lastName) {
        super(studentID, lastName);
        setAnnualTuition();
    }

    @Override
    public void setAnnualTuition() {
        annualTuition = TUITION_PER_SEMESTER * 2;
    }
}
