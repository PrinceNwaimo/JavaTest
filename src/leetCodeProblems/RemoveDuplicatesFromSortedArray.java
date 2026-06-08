package leetCodeProblems;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int zeros = 0; // count of duplicates found
        int index = 1;

        while (index < nums.length) {
            if (nums[index] == nums[index - 1]) {
                zeros += 1;
            } else {
                nums[index - zeros] = nums[index];
            }
            index += 1;
        }
        return nums.length - zeros; // new length = total - duplicates
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = sol.removeDuplicates(nums);

        System.out.println("New length: " + k);
        System.out.print("Array after removal: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
