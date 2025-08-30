package joyceInheritance;
import javax.swing.JOptionPane;
public class Person {
    protected String firstName;
    protected String lastName;
    protected String streetAddress;
    protected String zipCode;
    protected String phoneNumber;

    public void setData() {
        firstName = JOptionPane.showInputDialog("Enter first name");
        lastName = JOptionPane.showInputDialog("Enter last name");
        streetAddress = JOptionPane.showInputDialog("Enter street address");
        zipCode = JOptionPane.showInputDialog("Enter zip code");
        phoneNumber = JOptionPane.showInputDialog("Enter phone number");
    }

    public void display() {
        System.out.println(firstName + " " + lastName + ", " + streetAddress + ", " + zipCode + ", " + phoneNumber);
    }
}
