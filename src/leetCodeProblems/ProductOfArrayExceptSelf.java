package leetCodeProblems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] before = new int[n];
        int[] after = new int[n];
        int[] product = new int[n];

        // prefix products
        before[0] = 1;
        for (int i = 1; i < n; i++) {
            before[i] = before[i - 1] * nums[i - 1];
        }

        // suffix products
        after[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i + 1];
        }

        // final product
        for (int i = 0; i < n; i++) {
            product[i] = before[i] * after[i];
        }
        return product;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();

        int[] nums = {1, 2, 3, 4};
        int[] result = solver.productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}
