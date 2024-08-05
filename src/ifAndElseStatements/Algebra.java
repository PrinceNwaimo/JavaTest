package ifAndElseStatements;

import java.util.Scanner;

public class Algebra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("values for a, b, c , d , e, f : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        Cramer_Calculator(a, b, c, d,e, f);

    }
    public static void Cramer_Calculator(double a, double b, double c, double d, double e, double f){
        double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
        double y = ((a * f) - (e * c)) / ((a * d) - (b * c));

        if ( (a * d) - (b * c) == 0)
            System.out.println("The equation has no solution.");
        else
            System.out.println("X = " + x + " and  Y = " + y);
    }

}