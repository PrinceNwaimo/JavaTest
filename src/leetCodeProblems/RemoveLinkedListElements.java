package leetCodeProblems;

public class RemoveLinkedListElements {
    public ListNode3 removeElements(ListNode3 head, int val) {
        if (head == null) return head;

        ListNode3 dummy = new ListNode3(0);
        dummy.next = head;
        ListNode3 prev = dummy;

        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();


        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(6);
        head.next.next.next = new ListNode3(3);
        head.next.next.next.next = new ListNode3(6);

        ListNode3 result = solution.removeElements(head, 6);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
