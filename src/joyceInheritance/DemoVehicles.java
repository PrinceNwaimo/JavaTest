package joyceInheritance;

import javax.swing.*;

public class DemoVehicles {
    public static void main(String[] args) {
        Sailboat boat = new Sailboat();
        Bicycle bike = new Bicycle();
        JOptionPane.showMessageDialog(null, "\nVehicle descriptions:\n" + boat.toString() + "\n" + bike.toString());
    }

}
