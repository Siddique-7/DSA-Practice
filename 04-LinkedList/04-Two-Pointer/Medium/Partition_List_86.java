class ListNode86 {
    int val;
    ListNode86 next;
    ListNode86(int val) {
        this.val = val;
    }
}

public class Partition_List_86 {

    public ListNode86 partition(ListNode86 head, int x) {
        ListNode86 beforeHead = new ListNode86(0); // Dummy for < x
        ListNode86 afterHead = new ListNode86(0);  // Dummy for >= x

        ListNode86 before = beforeHead, after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Combine both lists
        after.next = null; // End the list properly
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public void printList(ListNode86 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
        // Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
        ListNode86 head = new ListNode86(1);
        head.next = new ListNode86(4);
        head.next.next = new ListNode86(3);
        head.next.next.next = new ListNode86(2);
        head.next.next.next.next = new ListNode86(5);
        head.next.next.next.next.next = new ListNode86(2);

        Partition_List_86 obj = new Partition_List_86();
        ListNode86 result = obj.partition(head, 3);

        obj.printList(result);
    }
}
