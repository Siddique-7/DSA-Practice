public class Longest_Subarray_After_Delete_1493 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};

        int result = longestSubarray(nums);
        System.out.println("Longest Subarray of 1s After Deleting One Element: " + result);
    }

    public static int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            // subtract 1 since we must delete one element
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
