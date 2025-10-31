class ListNode203 {
    int val;
    ListNode203 next;
    ListNode203(int val) {
        this.val = val;
    }
}

public class Remove_Linked_List_Elements_203 {

    public ListNode203 removeElements(ListNode203 head, int val) {
        // Use a dummy node to simplify edge cases (like deleting the head)
        ListNode203 dummy = new ListNode203(-1);
        dummy.next = head;
        ListNode203 current = dummy;

        // Traverse the list and skip nodes that match 'val'
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // Delete node
            } else {
                current = current.next;
            }
        }

        return dummy.next; // Return the actual head (may have changed)
    }

    // Utility function to print list
    public void printList(ListNode203 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
        ListNode203 head = new ListNode203(1);
        head.next = new ListNode203(2);
        head.next.next = new ListNode203(6);
        head.next.next.next = new ListNode203(3);
        head.next.next.next.next = new ListNode203(4);
        head.next.next.next.next.next = new ListNode203(5);
        head.next.next.next.next.next.next = new ListNode203(6);

        Remove_Linked_List_Elements_203 obj = new Remove_Linked_List_Elements_203();
        ListNode203 result = obj.removeElements(head, 6);

        System.out.print("After Removing 6s: ");
        obj.printList(result);
    }
}
