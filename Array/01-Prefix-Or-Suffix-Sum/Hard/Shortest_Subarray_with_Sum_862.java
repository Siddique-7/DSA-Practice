import java.util.*;

public class Shortest_Subarray_with_Sum_862 {
    
    // Function to find the length of the shortest subarray with sum ≥ K
    public static int shortestSubarray(int[] nums, int K) {
        int n = nums.length;
        long[] prefix = new long[n + 1]; // prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLength = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Maintain increasing order in deque
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= K) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return minLength <= n ? minLength : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        int K = 3;

        int result = shortestSubarray(nums, K);
        System.out.println("Length of shortest subarray with sum ≥ " + K + " is: " + result);
    }
}
