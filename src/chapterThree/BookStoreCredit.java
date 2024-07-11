package chapterThree;

import javax.swing.*;
import java.util.Scanner;

public class BookStoreCredit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JOptionPane.showInputDialog(null,"What is your name:  ");
        String name = input.nextLine();
        JOptionPane.showInputDialog(null,"What is your Grade Point Average: ");
        double credit = input.nextDouble();
        message(name,credit);
    }
    private static void message(String name, double credit){
        double compute = credit * 10;
        JOptionPane.showMessageDialog(null,name +","+credit+"G.P.A!!!" +", You won for yourself $"+compute+"credit for your academic performance");
    }
}
