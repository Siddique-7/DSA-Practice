import java.util.*;

public class Maximal_Rectangle_85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        // Convert each row into histogram heights
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Helper function (from 84)
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
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
        Maximal_Rectangle_85 sol = new Maximal_Rectangle_85();

        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(sol.maximalRectangle(matrix1)); // Output: 6

        char[][] matrix2 = {
            {'0', '1'},
            {'1', '0'}
        };
        System.out.println(sol.maximalRectangle(matrix2)); // Output: 1
    }
}
