package leetCodeProblems;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        int count1 = m - 1;
        int count2 = n - 1;

        while (count >= 0) {
            if (count2 < 0) {
                break;
            } else if (count1 < 0) {
                nums1[count] = nums2[count2];
                count2--;
            } else if (nums1[count1] > nums2[count2]) {
                nums1[count] = nums1[count1];
                count1--;
            } else {
                nums1[count] = nums2[count2];
                count2--;
            }
            count--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays solver = new MergeSortedArrays();

        // Test case: nums1 = [1,2,3,0,0,0], m=3, nums2=[2,5,6], n=3
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solver.merge(nums1, m, nums2, n);

        // Print result
        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // Output: Merged array: 1 2 2 3 5 6
    }
}
