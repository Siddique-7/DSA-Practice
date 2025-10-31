class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int val) {
        this.val = val;
    }
}

public class Sort_List_148 {

    public ListNode2 sortList(ListNode2 head) {
        // Base case: if 0 or 1 node, it's already sorted
        if (head == null || head.next == null) return head;

        // Step 1: Split list into two halves (find middle)
        ListNode2 slow = head;
        ListNode2 fast = head;
        ListNode2 prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect first half from second
        prev.next = null;

        // Step 2: Sort each half
        ListNode2 left = sortList(head);
        ListNode2 right = sortList(slow);

        // Step 3: Merge two sorted halves
        return merge(left, right);
    }

    private ListNode2 merge(ListNode2 l1, ListNode2 l2) {
        ListNode2 dummy = new ListNode2(-1);
        ListNode2 tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Utility function to print list
    public void printList(ListNode2 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 4 -> 2 -> 1 -> 3
        ListNode2 head = new ListNode2(4);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(1);
        head.next.next.next = new ListNode2(3);

        Sort_List_148 obj = new Sort_List_148();
        ListNode2 sorted = obj.sortList(head);

        System.out.print("Sorted List: ");
        obj.printList(sorted);
    }
}
