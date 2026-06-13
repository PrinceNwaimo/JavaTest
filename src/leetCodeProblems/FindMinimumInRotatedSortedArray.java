package leetCodeProblems;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If mid element >= end element, min is in right half
            if (nums[mid] >= nums[end]) {
                start = mid + 1;
            } else {
                // Min is in left half including mid
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solver = new FindMinimumInRotatedSortedArray();

        int[] nums1 = {3,4,5,1,2};
        int[] nums2 = {4,5,6,7,0,1,2};
        int[] nums3 = {11,13,15,17};

        System.out.println(solver.findMin(nums1));
        System.out.println(solver.findMin(nums2));
        System.out.println(solver.findMin(nums3));
    }
}
