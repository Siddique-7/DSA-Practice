import java.util.HashMap;

public class Continuous_Subarray_Sum_523 {
    
    public static boolean checkSubarraySum(int[] nums, int k) {
        // key: prefix sum modulo k, value: earliest index where it occurs
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // handle subarray starting at index 0
        
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            if (k != 0) {
                prefixSum %= k;
            }
            
            if (map.containsKey(prefixSum)) {
                if (i - map.get(prefixSum) >= 2) {
                    return true; // found a valid subarray
                }
            } else {
                map.put(prefixSum, i); // store first occurrence
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(checkSubarraySum(nums1, k1)); // Output: true
        
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(checkSubarraySum(nums2, k2)); // Output: true
        
        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(checkSubarraySum(nums3, k3)); // Output: false
    }
}
