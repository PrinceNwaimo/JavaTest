package leetCodeProblems;

import java.util.HashMap;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        HashMap<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i])) {
                int prevIndex = lastIndex.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            lastIndex.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate sol = new ContainsNearbyDuplicate();

        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("Test 1: " + sol.containsNearbyDuplicate(nums1, k1)); // true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Test 2: " + sol.containsNearbyDuplicate(nums2, k2)); // true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Test 3: " + sol.containsNearbyDuplicate(nums3, k3)); // false
    }
}
