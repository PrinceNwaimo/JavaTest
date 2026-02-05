package leetCodeProblems;

    public class Solution {
        //merge two sortedlist
        public static void main(String[] args) {
            // Example usage
            ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
            ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));
            ListNode result = mergeTwoLists(l1, l2);
            // Print result
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode head = new ListNode(0);
            ListNode temp = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }
            temp.next = (l1 != null) ? l1 : l2;
            return head.next;
        }
    }

     class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

