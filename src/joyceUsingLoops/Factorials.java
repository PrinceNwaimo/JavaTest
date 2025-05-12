package joyceUsingLoops;

public class Factorials {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            long factorial = calculateFactorial(i);
            System.out.println("Factorial of " + i + " is: " + factorial);
        }
    }

    public static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}



