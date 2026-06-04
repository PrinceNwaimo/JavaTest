package leetCodeProblems;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1};
        }

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int currSum = numbers[start] + numbers[end];
            if (currSum == target) {
                return new int[]{start + 1, end + 1}; // 1-indexed
            } else if (currSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{-1};
    }

    public static void main(String[] args) {
        TwoSumII soln = new TwoSumII();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        printArray(soln.twoSum(nums1, target1)); // [1, 2]

        int[] nums2 = {2, 3, 4};
        int target2 = 6;
        printArray(soln.twoSum(nums2, target2)); // [1, 3]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1? ", " : ""));
        }
        System.out.println("]");
    }
}
