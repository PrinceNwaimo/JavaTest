package chapterThree;

import java.util.Scanner;

public class PaintCalculator {
    static int compute = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the following for the room");
        System.out.println("Length of the room >> ");
        int length = input.nextInt();
        System.out.println("Width of the room >> ");
        int width = input.nextInt();
        System.out.println("Height of the room >> ");
        int height = input.nextInt();

        area(length,width,height);
        paint();
        cost();
    }
    private static void area(int Length, int Width, int height){
     compute = Length * Width * height;
        System.out.println(compute +" square feet");
    }
    private static int paint(){
        int gallons = compute / 350;
        System.out.println(gallons+ " gallons of paint");
        return gallons;
    }
    private static void cost(){
          int cup = paint();
          int cost = cup * 32;
        System.out.println("$"+cost);
    }
}
