package liangExceptionHandling;

import java.util.Scanner;

public class ParabolaEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double h = -1.0 * b / (2 * a);
        double k = c - (b * b) / (4.0 * a);

        System.out.println("h = " + h);
        System.out.println("k = " + k);
        System.out.println("The vertex form is y = " + a + "(x - " + h + ")^2 + " + k);
    }
}
