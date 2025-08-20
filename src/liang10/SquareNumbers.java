package liang10;

import java.math.BigInteger;

public class SquareNumbers {
    public static void main(String[] args) {
        BigInteger longMaxValue = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger n = BigInteger.valueOf((long) Math.ceil(Math.sqrt(Long.MAX_VALUE))).add(BigInteger.ONE);
        for (int i = 0; i < 10; i++) {
            System.out.println(n.multiply(n));
            n = n.add(BigInteger.ONE);
        }
    }
}
