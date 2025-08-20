package liang10;

import java.math.BigDecimal;
import java.math.MathContext;

public class ApproximateE {
    public static void main(String[] args) {
        MathContext mc = new MathContext(25);
        for (int i = 100; i <= 1000; i += 100) {
            BigDecimal e = calculateE(i, mc);
            System.out.println("e for i = " + i + ": " + e);
        }
    }

    public static BigDecimal calculateE(int n, MathContext mc) {
        BigDecimal e = BigDecimal.ONE;
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i), mc);
            e = e.add(BigDecimal.ONE.divide(factorial, mc), mc);
        }
        return e;
    }
}
