package chapterTwo;

import java.util.Scanner;

public class ConstantCreation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double PI = 3.14159;
        System.out.print("Enter the radius: ");
        double radius = input.nextDouble();


        double circumference = 2 * PI * radius;
        double area = PI * Math.pow(radius, 2);
        System.out.println(" Circumference is: " + circumference);
        System.out.println(" Area is " + area);

    }
}
