package liang10;

import java.math.BigInteger;

public class MersennePrime {
    public static void main(String[] args) {
        System.out.println("p\t2^p - 1");
        for (int p = 2; p <= 100; p++) {
            BigInteger mersenneNumber = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
            if (isPrime(mersenneNumber)) {
                System.out.println(p + "\t" + mersenneNumber);
            }
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
