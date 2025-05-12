package joyceUsingLoops;

public class Perfect {
    public static void main(String[] args) {
        System.out.println("Perfect numbers from 1 to 1000 are:");
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

}
