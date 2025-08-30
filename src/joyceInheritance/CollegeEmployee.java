package joyceInheritance;

import javax.swing.*;

public class CollegeEmployee extends Person{
    private String socialSecurityNumber;
    private double annualSalary;
    private String departmentName;

    @Override
    public void setData() {
        super.setData();
        socialSecurityNumber = JOptionPane.showInputDialog("Enter social security number");
        annualSalary = Double.parseDouble(JOptionPane.showInputDialog("Enter annual salary"));
        departmentName = JOptionPane.showInputDialog("Enter department name");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("SSN: " + socialSecurityNumber + ", Annual Salary: $" + annualSalary + ", Department: " + departmentName);
    }
}
