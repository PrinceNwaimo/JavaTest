package leetCodeProblems;

public class ReverseInteger {
    public int reverse(int x) {
        if (x < 0) {
            return -reverse(-x);
        }

        long result = 0;  // use long to catch overflow before it happens
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;  // int division truncates toward 0 in Java
        }

        // 0x7fffffff = 2147483647 = Integer.MAX_VALUE
        return result <= 0x7fffffff ? (int) result : 0;
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();

        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(120));
        System.out.println(r.reverse(1534236469));
    }
}
