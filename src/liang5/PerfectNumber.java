package liang5;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println("Perfect numbers less than 10,000:");

        // Loop through numbers from 1 to 9999
        for (int number = 1; number < 10000; number++) {
            int sumOfDivisors = 0;

            // Find divisors and calculate their sum
            for (int divisor = 1; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    sumOfDivisors += divisor;
                }
            }

            // Check if the sum of divisors equals the number
            if (sumOfDivisors == number) {
                System.out.println(number);
            }
        }
    }
}
