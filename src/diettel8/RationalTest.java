package diettel8;

import static diettel8.Rational.*;

public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);

        System.out.println("Rational number 1: " + r1);
        System.out.println("Rational number 2: " + r2);

        Rational sum = add(r1, r2);
        System.out.println("Sum: " + sum);

        Rational difference = subtract(r1, r2);
        System.out.println("Difference: " + difference);

        Rational product = multiply(r1, r2);
        System.out.println("Product: " + product);

        Rational quotient = divide(r1, r2);
        System.out.println("Quotient: " + quotient);

        System.out.println("Rational number 1 as decimal: " + r1.toString(2));
    }
}
