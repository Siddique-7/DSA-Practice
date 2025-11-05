public class Rotate_List_61 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // Step 1: Compute the length of the list
        int length = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Connect tail to head to form a circle
        tail.next = head;

        // Step 3: Find new tail: (length - k % length - 1)th node
        // Step 4: New head: (length - k % length)th node
        k = k % length;
        ListNode newTail = head;
        for(int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Step 5: Break the circle
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Rotate_List_61 sol = new Rotate_List_61();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = sol.rotateRight(head, 2);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 4 5 1 2 3
    }
}
