package leetCodeProblems;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        // Start from the last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // set to 0 and carry over
        }

        // If all digits were 9, e.g. [9,9,9] -> [1,0,0,0]
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
