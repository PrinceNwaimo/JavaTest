package leetCodeProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subset3 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = 1 << nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            List<Integer> subset = convert(i, nums);
            // Sort the subset
            subset.sort(null); // null means natural ordering
            // Add to set to remove duplicates
            result.add(subset);
        }

        // Convert Set back to List
        return new ArrayList<>(result);
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
        Subset3 subset3 = new Subset3();

        // Test cases
        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets with duplicates of " + Arrays.toString(nums1) + ":");
        System.out.println(subset3.subsetsWithDup(nums1));

        int[] nums2 = {4, 4, 4, 1, 4};
        System.out.println("\nSubsets with duplicates of " + Arrays.toString(nums2) + ":");
        System.out.println(subset3.subsetsWithDup(nums2));

        int[] nums3 = {1, 1, 2, 2};
        System.out.println("\nSubsets with duplicates of " + Arrays.toString(nums3) + ":");
        System.out.println(subset3.subsetsWithDup(nums3));

        int[] nums4 = {1, 2, 3};
        System.out.println("\nSubsets with duplicates of " + Arrays.toString(nums4) + ":");
        System.out.println(subset3.subsetsWithDup(nums4));
    }
}
