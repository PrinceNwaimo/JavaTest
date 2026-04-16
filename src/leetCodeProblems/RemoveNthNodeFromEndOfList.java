package leetCodeProblems;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(3);
        head.next.next.next = new ListNode3(4);
        head.next.next.next.next = new ListNode3(5);

        RemoveNthFromEnd sol = new RemoveNthFromEnd();
        ListNode3 result = sol.removeNthFromEnd(head, 2);

        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print("->");
            result = result.next;
        }

    }
}
