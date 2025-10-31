class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Remove_Duplicates_From_Sorted_List_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        // Traverse the list and skip duplicate values
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move to next distinct value
                current = current.next;
            }
        }
        return head;
    }

    // Utility function to print the linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        Remove_Duplicates_From_Sorted_List_83 obj = new Remove_Duplicates_From_Sorted_List_83();
        ListNode result = obj.deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        obj.printList(result);
    }
}
