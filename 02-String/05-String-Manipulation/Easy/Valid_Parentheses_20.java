import java.util.Stack;

public class Valid_Parentheses_20 {

    // Function to check if parentheses are valid
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "()";       // true
        String s2 = "()[]{}";   // true
        String s3 = "(]";       // false
        String s4 = "([{}])";   // true

        System.out.println(isValid(s1)); // Output: true
        System.out.println(isValid(s2)); // Output: true
        System.out.println(isValid(s3)); // Output: false
        System.out.println(isValid(s4)); // Output: true
    }
}
