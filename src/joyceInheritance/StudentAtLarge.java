package joyceInheritance;

public class StudentAtLarge extends Student2{
    private static final double TUITION_PER_SEMESTER = 2000;

    public StudentAtLarge(int studentID, String lastName) {
        super(studentID, lastName);
        setAnnualTuition();
    }

    @Override
    public void setAnnualTuition() {
        annualTuition = TUITION_PER_SEMESTER * 2;
    }
}
