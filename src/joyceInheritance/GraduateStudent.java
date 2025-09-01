package joyceInheritance;

public class GraduateStudent extends Student2{
    private static final double TUITION_PER_SEMESTER = 6000;

    public GraduateStudent(int studentID, String lastName) {
        super(studentID, lastName);
        setAnnualTuition();
    }

    @Override
    public void setAnnualTuition() {
        annualTuition = TUITION_PER_SEMESTER * 2;
    }
}
