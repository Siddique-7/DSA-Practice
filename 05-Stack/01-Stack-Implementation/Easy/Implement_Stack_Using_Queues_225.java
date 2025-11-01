import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_Using_Queues_225 {
    static class MyStack {
        private Queue<Integer> queue;

        // Constructor
        public MyStack() {
            queue = new LinkedList<>();
        }

        // Push element x onto stack
        public void push(int x) {
            queue.offer(x); // Add new element
            // Rotate all previous elements behind the new one
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        // Removes the element on top of the stack and returns it
        public int pop() {
            return queue.poll();
        }

        // Get the top element
        public int top() {
            return queue.peek();
        }

        // Return whether the stack is empty
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());   // Output: 2
        System.out.println(myStack.pop());   // Output: 2
        System.out.println(myStack.empty()); // Output: false
    }
}
