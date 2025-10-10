import java.util.*;

 class Subarray_Sum_Equals_K_560 {
    
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Output: " + subarraySum(nums1, k1)); // Expected: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Output: " + subarraySum(nums2, k2)); // Expected: 2

        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("Output: " + subarraySum(nums3, k3)); // Expected: 3
    }
}
