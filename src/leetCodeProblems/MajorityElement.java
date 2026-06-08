package leetCodeProblems;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Integer candidate = getCandidate(nums);
        if (candidate != null) {
            int candidateCount = 0;
            for (int num : nums) {
                if (num == candidate) {
                    candidateCount++;
                }
            }
            if (candidateCount >= nums.length / 2) {
                return candidate;
            }
        }
        return -1; // Java prefers int return, so use -1 instead of None
    }

    public Integer getCandidate(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (candidate == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count > 0 ? candidate : null;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 9, 3, 9, 3, 9};

        System.out.println("Majority in [3,2,3]: " + sol.majorityElement(nums1)); // 3
        System.out.println("Majority in [2,2,9,3,9,3,9]: " + sol.majorityElement(nums2)); // 9
    }
    //This is a Boyer-Moore Voting Algorithm for Leet Code 169//
}

