package diettelRecursion;

import java.math.BigInteger;

public class FactorialCalculator2 {
public static BigInteger factorial(BigInteger number){
    if(number.compareTo(BigInteger.ONE) <= 0){
        return BigInteger.ONE;
    }
    else {
        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }
}

    public static void main(String[] args) {
        for (int counter = 0; counter <= 50 ; counter++) {
            System.out.printf("%d! = %d%n", counter,factorial(BigInteger.valueOf(counter)));
        }
    }
}
