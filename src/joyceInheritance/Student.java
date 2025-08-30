package joyceInheritance;

import javax.swing.*;

public class Student extends Person{
    private String major;
    private double gradePointAverage;

    @Override
    public void setData() {
        super.setData();
        major = JOptionPane.showInputDialog("Enter major");
        gradePointAverage = Double.parseDouble(JOptionPane.showInputDialog("Enter grade point average"));
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + major + ", GPA: " + gradePointAverage);
    }
}
