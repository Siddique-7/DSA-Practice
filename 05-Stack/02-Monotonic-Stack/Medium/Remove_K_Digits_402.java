import java.util.*;

public class Remove_K_Digits_402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            // Remove digits larger than current
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // If still removals left
        while (k-- > 0 && !stack.isEmpty()) stack.pop();

        // Build final number
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Remove_K_Digits_402 sol = new Remove_K_Digits_402();
        System.out.println(sol.removeKdigits("1432219", 3)); // 1219
        System.out.println(sol.removeKdigits("10200", 1));   // 200
        System.out.println(sol.removeKdigits("10", 2));      // 0
    }
}
