class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Middle_Of_Linked_List_876 {
    public ListNode2 middleNode(ListNode2 head) {
        ListNode2 slow = head;
        ListNode2 fast = head;

        // Fast moves twice as quickly
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches end, slow is in middle
        return slow;
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        Middle_Of_Linked_List_876 obj = new Middle_Of_Linked_List_876();
        ListNode2 middle = obj.middleNode(head);
        System.out.println("Middle node value: " + middle.val); // 3
    }
}
