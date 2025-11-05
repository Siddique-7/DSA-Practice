public class Remove_Linked_List_Elements_203 {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeElements(ListNode head, int val) {
        // Dummy node simplifies removing head or multiple nodes
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        // Traverse the list
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Skip node with target value
            } else {
                curr = curr.next; // Move forward
            }
        }

        return dummy.next; // Return the new head
    }

    public static void main(String[] args) {
        Remove_Linked_List_Elements_203 sol = new Remove_Linked_List_Elements_203();

        // Example: 1->2->6->3->4->5->6, remove 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result = sol.removeElements(head, 6);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 1 2 3 4 5
    }
}
