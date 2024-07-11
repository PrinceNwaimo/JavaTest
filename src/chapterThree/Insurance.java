package chapterThree;

import java.util.Scanner;

public class Insurance {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age >> ");
        int age = input.nextInt();
        premium(age);
    }
    private static void premium(int age){
      int compute = (age/10)+15;
      int compute2 = compute * 20;
        System.out.println("$"+compute2);
    }
}
