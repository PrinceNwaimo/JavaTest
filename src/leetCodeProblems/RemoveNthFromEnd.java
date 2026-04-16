package leetCodeProblems;

public class RemoveNthFromEnd {
    public ListNode3 removeNthFromEnd(ListNode3 head, int n) {
        ListNode3 dummy = new ListNode3(0);
        dummy.next = head;
        ListNode3 fast = dummy;
        ListNode3 slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}

