package leetCodeProblems;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // Java doesn't have None. Use -1 or throw exception
        }

        int xorProd = 0;
        int xorProdIndex = 0;

        // XOR all numbers in array
        for (int i = 0; i < nums.length; i++) {
            xorProd ^= nums[i];
        }

        // XOR all indices from 0 to n
        for (int i = 0; i <= nums.length; i++) {
            xorProdIndex ^= i;
        }

        return xorProd ^ xorProdIndex;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();

        int[] nums1 = {3, 0, 1};
        System.out.println(mn.missingNumber(nums1));

        int[] nums2 = {0, 1};
        System.out.println(mn.missingNumber(nums2));

        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println(mn.missingNumber(nums3));
    }
}
