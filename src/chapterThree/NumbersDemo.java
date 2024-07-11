package chapterThree;

import java.util.Scanner;

public class NumbersDemo {
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
        System.out.print("Enter first Integer >> ");
        int number1 = input.nextInt();
        System.out.print("Enter second integer >> ");
        int number2 = input.nextInt();
        displayTwiceTheNumber(number1);
        displayNumberPlusFive(number1);
        displayNumberSquared(number2);
    }
    private static void displayTwiceTheNumber(int number){
        System.out.println(number * 2);
    }
    private static void displayNumberPlusFive(int number){
        System.out.println(number + 5);
    }
    private static void displayNumberSquared(int number){
        System.out.println(number * number);
    }
}
