import java.util.*;

public class Maximum_Size_Subarray_Sum_Equals_K_325 {
    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // When the subarray from start to i has sum == k
            if (sum == k) maxLen = i + 1;

            // If (sum - k) exists, we found a subarray summing to k
            if (prefixMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
            }

            // Store first occurrence of each prefix sum
            prefixMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -1, 5, -2, 3};
        int k1 = 3;
        System.out.println(maxSubArrayLen(nums1, k1)); // Expected: 4 ([1, -1, 5, -2])

        int[] nums2 = {-2, -1, 2, 1};
        int k2 = 1;
        System.out.println(maxSubArrayLen(nums2, k2)); // Expected: 2 ([-1, 2])

        int[] nums3 = {1, 2, 3};
        int k3 = 6;
        System.out.println(maxSubArrayLen(nums3, k3)); // Expected: 3 ([1,2,3])
    }
}

