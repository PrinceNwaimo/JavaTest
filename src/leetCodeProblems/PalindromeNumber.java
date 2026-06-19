package leetCodeProblems;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int rev = 0;
        int copy = x;

        while (copy != 0) {
            rev = rev * 10 + copy % 10;
            copy = copy / 10;  // int division in Java, same as Python //
        }

        return rev == x;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();


        System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome(-121));
        System.out.println(p.isPalindrome(10));
    }
}
