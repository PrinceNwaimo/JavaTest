package joyceInheritance;

public class LabCourse extends CollegeCourse{
    private static final double LAB_FEE = 50;

    public LabCourse(String department, int courseNumber, int credits) {
        super(department, courseNumber, credits);
    }

    @Override
    public void display() {
        System.out.println("Lab Course:");
        super.display();
        System.out.println("Total Fee: $" + (getFee() + LAB_FEE));
    }

    public double getTotalFee() {
        return getFee() + LAB_FEE;
    }
}
