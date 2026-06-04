package leetCodeProblems;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;  // duplicate found
            } else {
                seen.add(num);
            }
        }
        return false;  // no duplicates
    }

    public static void main(String[] args) {
        ContainsDuplicate soln = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println(soln.containsDuplicate(nums1)); // false
        System.out.println(soln.containsDuplicate(nums2)); // true
    }
}
