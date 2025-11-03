import java.util.*;

public class Sum_of_Subarray_Minimums_907 {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        int mod = 1_000_000_007;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];  // Distance to previous smaller element
        int[] right = new int[n]; // Distance to next smaller element

        // Step 1: Find distance to previous smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Step 2: Find distance to next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Step 3: Each element contributes arr[i] * left[i] * right[i]
        for (int i = 0; i < n; i++) {
            res = (res + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) res;
    }

    // Test
    public static void main(String[] args) {
        Sum_of_Subarray_Minimums_907 sol = new Sum_of_Subarray_Minimums_907();

        int[] arr1 = {3, 1, 2, 4};
        System.out.println(sol.sumSubarrayMins(arr1)); // Output: 17

        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println(sol.sumSubarrayMins(arr2)); // Output: 444
    }
}
