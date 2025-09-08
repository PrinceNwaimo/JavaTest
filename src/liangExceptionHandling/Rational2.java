package liangExceptionHandling;

import liangInterface.Comparable;

import java.math.BigInteger;

public class Rational2 extends Number implements Comparable<Rational> {
    private BigInteger numerator;
        private BigInteger denominator;

        public Rational2() {
            this(BigInteger.ZERO, BigInteger.ONE);
        }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    public Rational2(BigInteger numerator, BigInteger denominator) {
            BigInteger gcd = numerator.gcd(denominator);
            this.numerator = ((denominator.compareTo(BigInteger.ZERO) > 0) ? BigInteger.ONE : BigInteger.valueOf(-1)).multiply(numerator).divide(gcd);
            this.denominator = denominator.abs().divide(gcd);
        }

        public Rational2(long numerator, long denominator) {
            this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
        }

        public Rational2 add(Rational2 secondRational) {
            BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
            BigInteger d = denominator.multiply(secondRational.getDenominator());
            return new Rational2(n, d);
        }

        public BigInteger getNumerator() {
            return numerator;
        }

        public BigInteger getDenominator() {
            return denominator;
        }

        @Override
        public String toString() {
            if (denominator.equals(BigInteger.ONE)) {
                return numerator + "";
            } else {
                return numerator + "/" + denominator;
            }
        }

    @Override
    public int compareTo(Rational o) {
        return 0;
    }
}
