package leetCodeProblems;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedLinkedLists {
    // ListNode definition
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap ordered by node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // Push head of each non-null list
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLinkedLists soln = new MergeKSortedLinkedLists();

        // Build lists: [1->4->5], [1->3->4], [2->6]
        ListNode l1 = new ListNode(1); l1.next = new ListNode(4); l1.next = new ListNode(5);
        ListNode l2 = new ListNode(1); l2.next = new ListNode(3); l2.next = new ListNode(4);
        ListNode l3 = new ListNode(2); l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode merged = soln.mergeKLists(lists);

        // Print: 1->1->2->3->4->4->5->6
        while (merged != null) {
            System.out.print(merged.val + (merged.next != null ? "->" : ""));
            merged = merged.next;
        }
    }
}
