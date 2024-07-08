package chapterTwo;

import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
    public static void main(String[] args) {
        Scanner area = new Scanner(System.in);
        System.out.print(" Enter a number for radius: ");
        double radius = area.nextDouble();

        double area1 = radius * radius * 3.14159;
        System.out.println(" The area for the circle of radius " + radius + " is "+ area1);
    }

}
