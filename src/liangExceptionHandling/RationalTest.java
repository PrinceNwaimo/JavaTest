package liangExceptionHandling;

public class RationalTest {
    public static void main(String[] args) {
        Rational sum = new Rational(0, 1);
        for (int i = 1; i <= 99; i++) {
            Rational term = new Rational(i, i + 1);
            sum = sum.add(term);
        }
        System.out.println("The sum is " + sum);
    }
}
