import java.util.*;

public class Largest_Rectangle_in_Histogram_84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            // Maintain increasing stack
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    // Test
    public static void main(String[] args) {
        Largest_Rectangle_in_Histogram_84 sol = new Largest_Rectangle_in_Histogram_84();

        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(sol.largestRectangleArea(heights1)); // Output: 10

        int[] heights2 = {2, 4};
        System.out.println(sol.largestRectangleArea(heights2)); // Output: 4
    }
}
