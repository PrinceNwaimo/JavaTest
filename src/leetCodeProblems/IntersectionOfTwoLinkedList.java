package leetCodeProblems;

public class IntersectionOfTwoLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            } else if (l1 != null && l2 == null) {
                return l1;
            } else if (l1 == null && l2 != null) {
                return l2;
            } else {
                ListNode head = new ListNode(0);
                ListNode temp = head;

                while (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        temp.next = l1;
                        temp = temp.next;
                        l1 = l1.next;
                    } else {
                        temp.next = l2;
                        temp = temp.next;
                        l2 = l2.next;
                    }
                }

                if (l1 != null) {
                    temp.next = l1;
                }

                if (l2 != null) {
                    temp.next = l2;
                }

                return head.next;
            }
        }

        // psvm
        public static void main(String[] args) {
            // List 1: 1 -> 3 -> 5
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(3);
            l1.next.next = new ListNode(5);

            // List 2: 2 -> 4 -> 6
            ListNode l2 = new ListNode(2);
            l2.next = new ListNode(4);
            l2.next.next = new ListNode(6);

            ListNode result = mergeTwoLists(l1, l2);

            // Print merged list
            while (result != null) {
                System.out.print(result.val + " -> ");
                result = result.next;
            }
            System.out.println("null");
        }
    }

}
