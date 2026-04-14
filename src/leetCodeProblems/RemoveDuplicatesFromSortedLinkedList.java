package leetCodeProblems;

public class RemoveDuplicatesFromSortedLinkedList {
    public ListNode3 deleteDuplicates(ListNode3 head) {
        ListNode3 current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(1);
        head.next.next = new ListNode3(2);
        head.next.next.next = new ListNode3(3);
        head.next.next.next.next = new ListNode3(3);

        RemoveDuplicatesFromSortedLinkedList sol = new RemoveDuplicatesFromSortedLinkedList();
        ListNode3 result = sol.deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
