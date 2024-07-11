package chapterThree;

import java.util.Scanner;

public class Percentages {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first value >> ");
        double variable1 = input.nextDouble();
        System.out.print("Enter your second value >>");
        double variable2 = input.nextDouble();

        computePercent(variable1,variable2);
    }
    private static void computePercent(double variable1, double variable2){
        System.out.println(variable1 +","+variable2);
        double percent = (variable1 * 100)/variable2;
        System.out.println(variable1 +" is "+percent+" percent of "+variable2);
    }
}
