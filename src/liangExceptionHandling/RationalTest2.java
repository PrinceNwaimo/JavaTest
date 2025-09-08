package liangExceptionHandling;

import java.math.BigInteger;
import java.util.Scanner;

public class RationalTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decimal = scanner.next();
        Rational rational = convertToFraction(decimal);
        System.out.println("The fraction number is " + rational);
    }

    public static Rational convertToFraction(String decimal) {
        int sign = 1;
        if (decimal.charAt(0) == '-') {
            sign = -1;
            decimal = decimal.substring(1);
        }

        int index = decimal.indexOf('.');
        if (index == -1) {
            return new Rational(sign * Long.parseLong(decimal), 1);
        }

        String integerPart = decimal.substring(0, index);
        String fractionalPart = decimal.substring(index + 1);

        BigInteger numerator = BigInteger.valueOf(sign * Long.parseLong(integerPart)).multiply(BigInteger.TEN.pow(fractionalPart.length())).add(new BigInteger(fractionalPart));
        BigInteger denominator = BigInteger.TEN.pow(fractionalPart.length());

        return new Rational(numerator, denominator);
    }
}
