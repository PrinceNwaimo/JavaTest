package chapterTwo;

import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int number = input.nextInt();
        int number1 = number % 10;
        int number12 = number /10;
        int number2 = number12 % 10;
        int number22 = number12/10;

        int total = number1+number2+number22;
        System.out.println(" The Sum of the digits is "+total);
    }
}
