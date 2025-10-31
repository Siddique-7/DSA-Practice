class ListNode143 {
    int val;
    ListNode143 next;
    ListNode143(int val) {
        this.val = val;
    }
}

public class Reorder_List_143 {

    public void reorderList(ListNode143 head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle (using slow-fast pointers)
        ListNode143 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode143 prev = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode143 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Merge two halves
        ListNode143 first = head, second = prev;
        while (second != null) {
            ListNode143 temp1 = first.next;
            ListNode143 temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    public void printList(ListNode143 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 4 -> 5 => 1 -> 5 -> 2 -> 4 -> 3
        ListNode143 head = new ListNode143(1);
        head.next = new ListNode143(2);
        head.next.next = new ListNode143(3);
        head.next.next.next = new ListNode143(4);
        head.next.next.next.next = new ListNode143(5);

        Reorder_List_143 obj = new Reorder_List_143();
        obj.reorderList(head);

        obj.printList(head);
    }
}
