package leetCodeProblems;

public class ReversedLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode temp = null;
            ListNode nextNode = null;

            while (head != null) {
                nextNode = head.next;
                head.next = temp;
                temp = head;
                head = nextNode;
            }
            return temp;
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

            // Reverse the list
            ListNode reversedHead = solution.reverseList(node1);

            // Print reversed list
            while (reversedHead != null) {
                System.out.print(reversedHead.val + " ");
                reversedHead = reversedHead.next;
            }
            // Output: 4 3 2 1
        }
    }
}