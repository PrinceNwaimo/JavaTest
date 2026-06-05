package leetCodeProblems;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            int sum = 0;
            for (int n : nums) sum += n;
            return sum;
        }

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(currSum - target);

                if (diff == 0) {
                    return currSum; // exact match
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    result = currSum;
                }

                if (currSum <= target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 3));
    }
}
