package leetCodeProblems;

public class RemoveDuplicatesFromSortedLinkedListII {
    public ListNode3 deleteDuplicates(ListNode3 head) {
        if (head == null) return null;

        java.util.HashMap<Integer, Integer> countMap = new java.util.HashMap<>();
        ListNode3 current = head;
        while (current != null) {
            countMap.put(current.val, countMap.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        ListNode3 dummy = new ListNode3(0);
        ListNode3 tail = dummy;
        current = head;
        while (current != null) {
            if (countMap.get(current.val) == 1) {
                tail.next = new ListNode3(current.val);
                tail = tail.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(2);
        head.next.next.next = new ListNode3(3);
        head.next.next.next.next = new ListNode3(4);
        head.next.next.next.next.next = new ListNode3(4);

        RemoveDuplicatesFromSortedLinkedListII sol = new RemoveDuplicatesFromSortedLinkedListII();
        ListNode3 result = sol.deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
