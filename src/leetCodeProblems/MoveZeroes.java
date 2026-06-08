package leetCodeProblems;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int insertPos = 0; // position to place next non-zero

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Fill remaining positions with 0
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes sol = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);

        System.out.print("After moving zeroes: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: After moving zeroes: 1 3 12 0 0
    }
}
