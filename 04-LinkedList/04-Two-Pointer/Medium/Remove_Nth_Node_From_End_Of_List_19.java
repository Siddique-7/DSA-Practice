class ListNode19 {
    int val;
    ListNode19 next;
    ListNode19(int val) {
        this.val = val;
    }
}

public class Remove_Nth_Node_From_End_Of_List_19 {

    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        ListNode19 dummy = new ListNode19(0);
        dummy.next = head;

        ListNode19 fast = dummy;
        ListNode19 slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the Nth node from end
        slow.next = slow.next.next;

        return dummy.next; // Return the modified head
    }

    public void printList(ListNode19 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 4 -> 5, remove 2nd from end => 1 -> 2 -> 3 -> 5
        ListNode19 head = new ListNode19(1);
        head.next = new ListNode19(2);
        head.next.next = new ListNode19(3);
        head.next.next.next = new ListNode19(4);
        head.next.next.next.next = new ListNode19(5);

        Remove_Nth_Node_From_End_Of_List_19 obj = new Remove_Nth_Node_From_End_Of_List_19();
        head = obj.removeNthFromEnd(head, 2);

        obj.printList(head);
    }
}
