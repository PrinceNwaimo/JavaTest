package liang10;

import java.math.BigInteger;

public class DivisibleBy2Or3 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("1");
        num = num.add(BigInteger.TEN.pow(49));
        int count = 0;
        while (count < 10) {
            if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
                System.out.println(num);
                count++;
            }
            num = num.add(BigInteger.ONE);
        }
    }
}
