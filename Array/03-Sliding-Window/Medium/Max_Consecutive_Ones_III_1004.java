public class Max_Consecutive_Ones_III_1004 {
    // Method to find max consecutive 1s after flipping at most k zeros
    public static int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            // Shrink window if zeros exceed k
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int k = 2;

        int result = longestOnes(nums, k);

        System.out.println("Maximum consecutive 1s after flipping: " + result);
    }
}
