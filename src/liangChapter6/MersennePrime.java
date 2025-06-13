package liangChapter6;

public class MersennePrime {
    public static void main(String[] args) {
        System.out.println("p\t2^p –1");
        for (int p = 2; p <= 31; p++) {
            if (isPrime(p) && isPrime((int) Math.pow(2, p) - 1)) {
                System.out.println(p + "\t" + ((int) Math.pow(2, p) - 1));
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
