package leetCodeProblems;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // either extend previous subarray or start new at i
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solver = new MaximumSubarray();

        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};
        int[] nums4 = {-1,-2,-3,-4};

        System.out.println(solver.maxSubArray(nums1));
        System.out.println(solver.maxSubArray(nums2));
        System.out.println(solver.maxSubArray(nums3));
        System.out.println(solver.maxSubArray(nums4));
    }
}
