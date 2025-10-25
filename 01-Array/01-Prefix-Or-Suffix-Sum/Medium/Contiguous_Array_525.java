import java.util.HashMap;

public class Contiguous_Array_525 {

    public static int findMaxLength(int[] nums) {
        // key: cumulative sum, value: first index it occurred
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // handle subarray starting from index 0

        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, 1 as 1
            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        System.out.println(findMaxLength(nums1)); // Output: 2

        int[] nums2 = {0, 1, 0};
        System.out.println(findMaxLength(nums2)); // Output: 2

        int[] nums3 = {0, 0, 1, 0, 1, 1, 0};
        System.out.println(findMaxLength(nums3)); // Output: 6
    }
}
