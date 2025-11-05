import java.util.*;

public class Flatten_Multilevel_Doubly_Linked_List_430 {

    // Definition for a Node.
    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;
        Node(int val) { this.val = val; }
    }

    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;
        Stack<Node> stack = new Stack<>();

        while (curr != null) {
            // If current node has a child
            if (curr.child != null) {
                // If there is a next node, push it to stack to visit later
                if (curr.next != null) stack.push(curr.next);

                // Connect current node to child
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null; // remove the child pointer
            }

            // If reached end of current level and stack is not empty
            if (curr.next == null && !stack.isEmpty()) {
                Node nextNode = stack.pop();
                curr.next = nextNode;
                nextNode.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }

    // Helper to print flattened list
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Flatten_Multilevel_Doubly_Linked_List_430 sol = new Flatten_Multilevel_Doubly_Linked_List_430();

        // Example:
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        // Setup next pointers
        n1.next = n2; n2.prev = n1; n2.next = n3; n3.prev = n2; n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4; n5.next = n6; n6.prev = n5;

        // Setup child pointers
        n3.child = n7; n7.next = n8; n8.prev = n7;

        Node flat = sol.flatten(n1);
        sol.printList(flat);
        // Expected Output: 1 2 3 7 8 4 5 6
    }
}
