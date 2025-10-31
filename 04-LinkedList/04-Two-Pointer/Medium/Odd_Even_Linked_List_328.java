class ListNode328 {
    int val;
    ListNode328 next;
    ListNode328(int val) {
        this.val = val;
    }
}

public class Odd_Even_Linked_List_328 {

    public ListNode328 oddEvenList(ListNode328 head) {
        if (head == null) return null;

        ListNode328 odd = head;             // odd index nodes
        ListNode328 even = head.next;       // even index nodes
        ListNode328 evenHead = even;        // save start of even list

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Connect odd list to even list
        odd.next = evenHead;

        return head;
    }

    public void printList(ListNode328 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 4 -> 5 => 1 -> 3 -> 5 -> 2 -> 4
        ListNode328 head = new ListNode328(1);
        head.next = new ListNode328(2);
        head.next.next = new ListNode328(3);
        head.next.next.next = new ListNode328(4);
        head.next.next.next.next = new ListNode328(5);

        Odd_Even_Linked_List_328 obj = new Odd_Even_Linked_List_328();
        ListNode328 result = obj.oddEvenList(head);

        obj.printList(result);
    }
}
