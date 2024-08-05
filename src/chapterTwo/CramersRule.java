package chapterTwo;

import java.util.Scanner;

public class CramersRule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("values for a, b, c , d , e, f : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();


        double x = ((e*d)-(b*f))/((a*d)-(b*c));
        double y = ((a*f) - (e*c))/((a*d)-(b*c));

        System.out.println("X = "+x + " Y = "+y);
    }
}
