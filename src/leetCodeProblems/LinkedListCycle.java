package leetCodeProblems;

public class LinkedListCycle {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // Create a linked list with a cycle
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node2; // Create cycle

            System.out.println(solution.hasCycle(node1)); // Output: true

            // Create a linked list without a cycle
            ListNode nodeA = new ListNode(1);
            ListNode nodeB = new ListNode(2);
            ListNode nodeC = new ListNode(3);

            nodeA.next = nodeB;
            nodeB.next = nodeC;

            System.out.println(solution.hasCycle(nodeA)); // Output: false
        }
    }
}
