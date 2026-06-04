package leetCodeProblems;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2 || k == 0) {
            return;
        }
        k = k % n;
        int a = n - k;

        reverse(nums, 0, a - 1);
        reverse(nums, a, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        RotateArray soln = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        soln.rotate(nums, 3);

        // Print result
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 5 6 7 1 2 3 4
    }
}
