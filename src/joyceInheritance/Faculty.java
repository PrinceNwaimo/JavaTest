package joyceInheritance;

import javax.swing.*;

public class Faculty extends CollegeEmployee {
        private boolean isTenured;

        @Override
        public void setData() {
            super.setData();
            isTenured = Boolean.parseBoolean(JOptionPane.showInputDialog("Is faculty member tenured? (true/false)"));
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Tenured: " + isTenured);
        }
}
