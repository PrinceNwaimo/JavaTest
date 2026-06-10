package leetCodeProblems;
import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> resultList = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII solver = new IntersectionOfTwoArraysII();

        // Test case 1: nums1 = [1,2,2,1], nums2 = [2,2] → [2,2]
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = solver.intersect(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(res));

        // Test case 2: nums1 = [4,9,5], nums2 = [9,4,9,8,4] → [4,9]
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] res2 = solver.intersect(nums3, nums4);
        System.out.println("Intersection: " + Arrays.toString(res2));
    }
}
