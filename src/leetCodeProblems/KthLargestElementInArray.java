package leetCodeProblems;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        // Min-heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first k elements
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // For rest, if bigger than heap top, replace
        for (int j = k; j < nums.length; j++) {
            if (nums[j] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[j]);
            }
        }

        return minHeap.peek(); // root of min-heap = kth largest
    }

    public static void main(String[] args) {
        KthLargestElementInArray soln = new KthLargestElementInArray();

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(soln.findKthLargest(nums1, k1)); // 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(soln.findKthLargest(nums2, k2)); // 4
    }
}
