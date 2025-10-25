import java.util.HashMap;

public class Count_Number_of_Nice_Subarrays_1248 {
    // Method to count nice subarrays
    public static int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix

        int oddCount = 0;
        int result = 0;

        for (int num : nums) {
            if (num % 2 != 0) oddCount++;

            // Check if there is a prefix sum that forms a nice subarray
            result += prefixCount.getOrDefault(oddCount - k, 0);

            // Update the prefix map
            prefixCount.put(oddCount, prefixCount.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = numberOfSubarrays(nums, k);

        System.out.println("Number of nice subarrays: " + result);
    }
}
