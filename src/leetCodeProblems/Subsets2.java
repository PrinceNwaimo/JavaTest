package leetCodeProblems;
import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = 1 << nums.length; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> subset = convert(i, nums);
            result.add(subset);
        }
        return result;
    }

    public List<Integer> convert(int i, int[] nums) {
        int k = i;
        int index = 0;
        List<Integer> subset = new ArrayList<>();

        while (k > 0) {
            if ((k & 1) == 1) {
                subset.add(nums[index]);
            }
            index++;
            k >>= 1;
        }
        return subset;
    }

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();

        // Test cases
        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets of [1, 2, 3]:");
        System.out.println(subsets.subsets(nums1));

        int[] nums2 = {4, 5, 6, 7};
        System.out.println("\nSubsets of [4, 5, 6, 7]:");
        System.out.println(subsets.subsets(nums2));

        int[] nums3 = {1, 2, 3, 4};
        System.out.println("\nSubsets of [1, 2, 3, 4]:");
        System.out.println(subsets.subsets(nums3));

        // Test with empty array
        int[] nums4 = {};
        System.out.println("\nSubsets of []:");
        System.out.println(subsets.subsets(nums4));
    }
}
