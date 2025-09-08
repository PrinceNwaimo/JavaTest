package liangExceptionHandling;

import java.util.Scanner;

public class ComplexTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first complex number (real and imaginary part): ");
        double real1 = scanner.nextDouble();
        double imaginary1 = scanner.nextDouble();
        Complex complex1 = new Complex(real1, imaginary1);

        System.out.print("Enter the second complex number (real and imaginary part): ");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();
        Complex complex2 = new Complex(real2, imaginary2);

        System.out.println("Complex number 1: " + complex1);
        System.out.println("Complex number 2: " + complex2);

        Complex sum = complex1.add(complex2);
        System.out.println("Sum: " + sum);

        Complex difference = complex1.subtract(complex2);
        System.out.println("Difference: " + difference);

        Complex product = complex1.multiply(complex2);
        System.out.println("Product: " + product);

        Complex quotient = complex1.divide(complex2);
        System.out.println("Quotient: " + quotient);

        System.out.println("Absolute value of complex number 1: " + complex1.abs());
    }
}
