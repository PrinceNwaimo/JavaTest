package leetCodeProblems;
import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end = nums[i];
            } else {
                res.add(toStr(start, end));
                start = end = nums[i];
            }
        }
        res.add(toStr(start, end));
        return res;
    }

    private String toStr(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(sr.summaryRanges(nums1));

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(sr.summaryRanges(nums2));
    }
}
