public class Add_Two_Numbers_2 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify handling head
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // Traverse both lists until all nodes processed
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with carry
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10; // Update carry
            curr.next = new ListNode(sum % 10); // Node with current digit
            curr = curr.next;
        }

        return dummy.next; // Head of the new list
    }

    public static void main(String[] args) {
        Add_Two_Numbers_2 sol = new Add_Two_Numbers_2();

        // Example: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = sol.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 7 0 8
    }
}
