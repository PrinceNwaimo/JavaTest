package liangChapter6;

public class Emirp {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;

        while (count < 100) {
            if (isEmirp(num)) {
                System.out.print(num + " ");
                count++;

                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            num++;
        }
    }

    public static boolean isEmirp(int num) {
        int reverse = reverse(num);
        return isPrime(num) && isPrime(reverse) && num != reverse;
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

    public static int reverse(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        return Integer.parseInt(sb.reverse().toString());
    }

}
