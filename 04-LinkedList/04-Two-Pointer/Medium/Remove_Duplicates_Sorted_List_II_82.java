public class Remove_Duplicates_Sorted_List_II_82 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases where the first node(s) need deletion
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // Pointer to node before the current sequence
        ListNode curr = head;

        while (curr != null) {
            // Check if current node has duplicates
            boolean isDuplicate = false;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next; // Skip the duplicate node
                isDuplicate = true;
            }

            if (isDuplicate) {
                // Skip all duplicates
                prev.next = curr.next;
            } else {
                // No duplicate, move prev forward
                prev = prev.next;
            }
            curr = curr.next; // Move current forward
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Remove_Duplicates_Sorted_List_II_82 sol = new Remove_Duplicates_Sorted_List_II_82();

        // Example: 1->2->3->3->4->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode result = sol.deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 1 2 5
    }
}
