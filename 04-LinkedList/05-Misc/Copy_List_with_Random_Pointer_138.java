import java.util.*;

public class Copy_List_with_Random_Pointer_138 {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) { this.val = val; this.next = null; this.random = null; }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a mapping from original nodes to their copies
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next); // may be null
            map.get(curr).random = map.get(curr.random); // may be null
            curr = curr.next;
        }

        return map.get(head); // Return the head of the copied list
    }

    public static void main(String[] args) {
        Copy_List_with_Random_Pointer_138 sol = new Copy_List_with_Random_Pointer_138();

        // Example: Node list with random pointers
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n1.random = null; n2.random = n1; n3.random = n5; n4.random = n3; n5.random = n1;

        Node copy = sol.copyRandomList(n1);

        // Print copied list values and random pointers
        Node c = copy;
        while (c != null) {
            int randVal = (c.random != null) ? c.random.val : -1;
            System.out.println("Node val: " + c.val + ", Random points to: " + randVal);
            c = c.next;
        }
    }
}
