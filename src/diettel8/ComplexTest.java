package diettel8;

public class ComplexTest {
    public static void main(String[] args) {
        Complex complex1 = new Complex(3.0, 4.0);
        Complex complex2 = new Complex(1.0, 2.0);

        System.out.println("Complex number 1: " + complex1);
        System.out.println("Complex number 2: " + complex2);

        Complex sum = complex1.add(complex2);
        System.out.println("Sum: " + sum);

        Complex difference = complex1.subtract(complex2);
        System.out.println("Difference: " + difference);
    }
}
