public class Maximum_Average_Subarray_I_643 {
    public static double findMaxAverage(int[] nums, int k) {
        // Compute the sum of the first 'k' elements (initial window)
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Subtract the element going out of the window and add the new one
            sum += nums[i] - nums[i - k];
            // Track the maximum sum of any window
            maxSum = Math.max(maxSum, sum);
        }

        // Return the maximum average
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println(findMaxAverage(nums1, k1)); // Expected: 12.75

        int[] nums2 = {5};
        int k2 = 1;
        System.out.println(findMaxAverage(nums2, k2)); // Expected: 5.0
    }
}