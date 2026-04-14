package leetCodeProblems;

public class LinkedListCycle2 {
    public ListNode3 detectCycle(ListNode3 head) {
        if (head == null) return null;

        ListNode3 fast = head;
        ListNode3 slow = head;
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
        ListNode3 node1 = new ListNode3(1);
        ListNode3 node2 = new ListNode3(2);
        ListNode3 node3 = new ListNode3(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2; // Create cycle

        LinkedListCycle2 solution = new LinkedListCycle2();
        ListNode3 cycleStart = solution.detectCycle(node1);
        if (cycleStart != null) {
            System.out.println("Cycle starts at: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}


