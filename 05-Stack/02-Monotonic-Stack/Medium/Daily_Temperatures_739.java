import java.util.*;

public class Daily_Temperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop until we find a day with lower temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Daily_Temperatures_739 sol = new Daily_Temperatures_739();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(sol.dailyTemperatures(arr)));
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
