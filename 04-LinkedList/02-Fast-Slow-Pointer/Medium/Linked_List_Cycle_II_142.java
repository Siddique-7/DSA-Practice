class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Linked_List_Cycle_II_142 {
    public ListNode3 detectCycle(ListNode3 head) {
        if (head == null) return null;

        ListNode3 slow = head;
        ListNode3 fast = head;
        boolean isCycle = false;

        // Detect cycle first
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;

        // Move slow to head and advance both one step at a time
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both meet at the cycle start node
        return slow;
    }

    public static void main(String[] args) {
        // Create list: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode3 head = new ListNode3(3);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(0);
        head.next.next.next = new ListNode3(-4);
        head.next.next.next.next = head.next; // Create cycle at node with val=2

        Linked_List_Cycle_II_142 obj = new Linked_List_Cycle_II_142();
        ListNode3 start = obj.detectCycle(head);

        if (start != null)
            System.out.println("Cycle starts at node with value: " + start.val);
        else
            System.out.println("No cycle found");
    }
}
