package leetCodeProblems;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        int zeroes = 0;

        while (count < nums.length) {
            if (nums[count] == val) {
                zeroes++;
            } else {
                nums[count - zeroes] = nums[count];
            }
            count++;
        }
        return nums.length - zeroes;
    }

    public static void main(String[] args) {
        RemoveElement solver = new RemoveElement();

        // Test case 1: nums = [3,2,2,3], val = 3 → k=2, nums=[2,2,_,_]
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solver.removeElement(nums1, val1);
        System.out.println("k = " + k1);
        System.out.print("nums after: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        // Test case 2: nums = [0,1,2,2,3,0,4,2], val = 2 → k=5
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solver.removeElement(nums2, val2);
        System.out.println("k = " + k2);
        System.out.print("nums after: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
