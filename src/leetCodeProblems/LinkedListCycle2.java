package leetCodeProblems;

public class LinkedListCycle2 {
    public ListNode2 detectCycle(ListNode2 head) {
        if (head == null) return null;

        ListNode2 fast = head;
        ListNode2 slow = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return null;

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create a cycle for testing
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2; // Create cycle

        LinkedListCycle2 solution = new LinkedListCycle2();
        ListNode2 cycleStart = solution.detectCycle(node1);
        if (cycleStart != null) {
            System.out.println("Cycle starts at: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}


