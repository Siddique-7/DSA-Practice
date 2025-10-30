class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Linked_List_Cycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, there’s a cycle
            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Creating a cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creates cycle

        Linked_List_Cycle_141 obj = new Linked_List_Cycle_141();
        System.out.println("Has cycle? " + obj.hasCycle(head)); // true
    }
}
