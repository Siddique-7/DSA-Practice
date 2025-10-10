class Range_Sum_Query_2D_Immutable_304 {
    private int[][] prefixSum; // 2D prefix sum array

    // Constructor: precompute the 2D prefix sums
    public Range_Sum_Query_2D_Immutable_304(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixSum = new int[rows + 1][cols + 1]; // Extra row & col for easier computation

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = matrix[i-1][j-1] 
                                + prefixSum[i-1][j] 
                                + prefixSum[i][j-1] 
                                - prefixSum[i-1][j-1];
            }
        }
    }

    // Method to return sum of elements in submatrix (row1,col1) to (row2,col2)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2+1][col2+1] 
             - prefixSum[row1][col2+1] 
             - prefixSum[row2+1][col1] 
             + prefixSum[row1][col1];
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        Range_Sum_Query_2D_Immutable_304 obj = new Range_Sum_Query_2D_Immutable_304(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(obj.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(obj.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}
