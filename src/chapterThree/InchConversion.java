package chapterThree;

import java.util.Scanner;

public class InchConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number in Inches >> ");
        double number = input.nextDouble();
        Feet(number);
        Yard(number);

    }
    private static void Feet(double number){
    double foot = number /12;
        System.out.println(foot +" feet");
    }
    private static void Yard (double number){
        double yard = number/36;
        System.out.println(yard +" yard");
    }
}
