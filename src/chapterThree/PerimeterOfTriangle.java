package chapterThree;

import java.util.Scanner;

public class PerimeterOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three edges of the triangle: ");
        double edge1 = input.nextDouble();
        double edge2 = input.nextDouble();
        double edge3 = input.nextDouble();

        if (edge1 + edge2 > edge3 && edge1 + edge3 > edge2 && edge2 + edge3 > edge1) {
            double perimeter = edge1 + edge2 + edge3;
            System.out.println("Perimeter: " + perimeter);
        } else {
            System.out.println("Invalid input: Edge lengths do not form a valid triangle.");
        }
    }




}
