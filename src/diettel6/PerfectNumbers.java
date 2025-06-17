package diettel6;

public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println("Perfect numbers between 1 and 1000:");
        for (int i = 1; i <= 10000; i++) {
            if (isPerfect(i)) {
                System.out.println(i + " is a perfect number. Its factors are:");
                printFactors(i);
            }
        }
    }

    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void printFactors(int num) {
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
