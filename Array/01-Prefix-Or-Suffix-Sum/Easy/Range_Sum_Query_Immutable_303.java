// Prefix Sum approach for range sum queries

public class Range_Sum_Query_Immutable_303 {

    // Inner class as required by LeetCode
    static class NumArray {
        private int[] prefixSum;

        // Constructor: precompute prefix sums
        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];  // prefixSum[0] = 0
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        // Get sum from index left to right (inclusive)
        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

    // Test the implementation
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);

        System.out.println("Sum [0, 2] → " + obj.sumRange(0, 2));  // Output: 1
        System.out.println("Sum [2, 5] → " + obj.sumRange(2, 5));  // Output: -1
        System.out.println("Sum [0, 5] → " + obj.sumRange(0, 5));  // Output: -3
    }
}
