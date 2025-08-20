package liang10;

import java.math.BigInteger;

public class LargePrimeNumbers {
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        int count = 0;
        while (count < 5) {
            if (isPrime(num)) {
                System.out.println(num);
                count++;
            }
            num = num.add(BigInteger.ONE);
        }
    }

    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        if (num.equals(BigInteger.valueOf(2)) || num.equals(BigInteger.valueOf(3))) {
            return true;
        }
        if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
            return false;
        }
        BigInteger i = BigInteger.valueOf(5);
        while (i.multiply(i).compareTo(num) <= 0) {
            if (num.mod(i).equals(BigInteger.ZERO) || num.mod(i.add(BigInteger.valueOf(2))).equals(BigInteger.ZERO)) {
                return false;
            }
            i = i.add(BigInteger.valueOf(6));
        }
        return true;
    }
}
