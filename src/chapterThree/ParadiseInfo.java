package chapterThree;

import java.util.Scanner;

import static chapterThree.First.displayAddress;

public class ParadiseInfo {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        displayInfo();
        displayAddress();
        calculateGross(2.5);
        compound(500);
    }
    private static void displayInfo(){
        System.out.println("Paradise Day Spa wants to Pamper you.");
        System.out.println("We will make you look good.");
    }
    public static void calculateGross(double hours){
        final double STD_RATE = 13.75;
        double gross;
        gross = hours * STD_RATE;
        System.out.println(hours + "hours at $" + STD_RATE + " per hour is $" + gross);
    }
    public static void compound(double money){
        double dollar = 1500;
        double naira = dollar * money;
        System.out.println("Your amount is " + naira+"₦");
    }
}
