package leetCodeProblems;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;           // add without carry
        int carry = (a & b) << 1;  // carry bits
        return getSum(sum, carry); // recurse until no carry left
    }

    public static void main(String[] args) {
        SumOfTwoIntegers s = new SumOfTwoIntegers();

        System.out.println(s.getSum(1, 2));
        System.out.println(s.getSum(-2, 3));
        System.out.println(s.getSum(5, 5));
    }
}
