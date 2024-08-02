package ifAndElseStatements;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b , c : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double b2 = Math.pow(b,2);
        double b24ac = b2 - (4 * a * c);
        double SquareRootb24ac = Math.pow(b24ac,0.5);

        double r1 = (-b + SquareRootb24ac)/(2 * a);
        double r2 = (-b - SquareRootb24ac)/(2 * a);

        System.out.println("The roots of the equation are : "+ r1+" "+r2);

    }
}
