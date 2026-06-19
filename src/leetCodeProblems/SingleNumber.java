package leetCodeProblems;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0; // Java can't return None. LeetCode expects 0 or just skip check
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int xorProd = 0;
        for (int num : nums) {
            xorProd ^= num;
        }
        return xorProd;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();

        System.out.println(s.singleNumber(new int[]{2, 2, 1}));
        System.out.println(s.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(s.singleNumber(new int[]{1}));
    }
}
