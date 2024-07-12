package chapterThree;

public class Student {

    private int ID;
    private int CreditHours;
    private double GP;

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Student() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int creditHours) {
        this.CreditHours = creditHours;
    }

    public double getGP() {
        return GP;
    }

    public void setGP(double GP) {
        this.GP = GP;
    }

    public double ComputeGPA(){
        double GPA = GP/CreditHours;
        return GPA;
    }
}
