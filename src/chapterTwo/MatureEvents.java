package chapterTwo;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Scanner;

public class MatureEvents {
    public static void main(String[] args) {
//        String person;
//        person = JOptionPane.showInputDialog(null, "How many guest are attending");
//        JOptionPane.showMessageDialog(null, "Hello" + person +"persons are attending");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of guests: ");
        int number = input.nextInt();
        int pricePerPerson = 35;
        int totalPrice = number * pricePerPerson;
        System.out.println(" The number of guest is: "+ number+ "\n The Price for each guest is :"+ pricePerPerson+ "\n The total price is: "+ "$"+totalPrice);

        if(number >= 50){
            System.out.println("Big Event");
        }
        else {
            System.out.println("Small event");
        }
    }

}
