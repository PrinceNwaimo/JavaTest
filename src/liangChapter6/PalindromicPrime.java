package liangChapter6;

public class PalindromicPrime {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;

        while (count < 100) {
            if (isPrime(num) && isPalindrome(num)) {
                System.out.print(num + " ");
                count++;

                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            num++;
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

    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
