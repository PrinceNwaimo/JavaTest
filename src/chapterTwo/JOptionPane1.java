package chapterTwo;

import javax.swing.*;

public class JOptionPane1 {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog(null, "What is your name?");
        JOptionPane.showMessageDialog(null,"Hello, " + result + "!");
    }
}
