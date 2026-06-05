package leetCodeProblems;
import java.util.Arrays;

public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;

        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];

                if (currSum < target) {
                    // If nums[i] + nums[start] + nums[end] < target,
                    // then all pairs between start and end also work
                    // because array is sorted
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 0, -2};
        int target = 4;
        System.out.println(threeSumSmaller(nums, target));

    }
}
