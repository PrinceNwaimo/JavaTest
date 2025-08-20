package liang10;

import java.math.BigInteger;

public class DivisibleBy5Or6 {
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        int count = 0;
        while (count < 10) {
            if (num.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO)) {
                System.out.println(num);
                count++;
            }
            num = num.add(BigInteger.ONE);
        }
    }
}
