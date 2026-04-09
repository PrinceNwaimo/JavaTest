package leetCodeProblems;

public class PalindromeLinkedList {
        public boolean isPalindrome(ListNode3 head) {
            if (head == null) return true;
            if (head.next == null) return true;

            ListNode3 fast = head;
            ListNode3 slow = head;
            java.util.Stack<Integer> stack = new java.util.Stack<>();

            while (fast != null && fast.next != null) {
                stack.push(slow.val);
                fast = fast.next.next;
                slow = slow.next;
            }

            if (fast != null) slow = slow.next; // odd length, skip middle

            while (slow != null) {
                if (slow.val != stack.pop()) return false;
                slow = slow.next;
            }
            return true;
        }

        public static void main(String[] args) {
            // Example usage:
            ListNode3 head = new ListNode3(1);
            head.next = new ListNode3(2);
            head.next.next = new ListNode3(3);
            head.next.next.next = new ListNode3(2);
            head.next.next.next.next = new ListNode3(1);

            PalindromeLinkedList pll = new PalindromeLinkedList();
            System.out.println(pll.isPalindrome(head)); // true
        }
    }



