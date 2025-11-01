import java.util.Stack;

public class Min_Stack_155 {
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        // Constructor
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Push element x onto stack
        public void push(int val) {
            stack.push(val);
            // Push the minimum value so far
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        // Remove the element on top of the stack
        public void pop() {
            int removed = stack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }

        // Get the top element
        public int top() {
            return stack.peek();
        }

        // Retrieve the minimum element in the stack
        public int getMin() {
            return minStack.peek();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }
}
