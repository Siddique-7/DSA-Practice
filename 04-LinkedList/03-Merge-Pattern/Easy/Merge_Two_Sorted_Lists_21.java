class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Merge_Two_Sorted_Lists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node simplifies handling the head
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Compare nodes and link the smaller one
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes (if any)
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }

    // Utility function to print a list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: list1 = 1->2->4, list2 = 1->3->4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        Merge_Two_Sorted_Lists_21 obj = new Merge_Two_Sorted_Lists_21();
        ListNode merged = obj.mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        obj.printList(merged);
    }
}
