package leetCodeProblems;

public class DeletingNodeFromALinkedList {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) return;

            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // Create a linked list: 1 -> 2 -> 3 -> 4
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;

            // Delete node2
            solution.deleteNode(node2);

            // Print list
            ListNode head = node1;
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            // Output: 1 3 4
        }
    }
}
