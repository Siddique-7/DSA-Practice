import java.util.*;

public class Longest_Consecutive_Sequence_128 {

    public static int longestConsecutive(int[] nums) {
        // Use a HashSet for O(1) average lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Iterate over all numbers
        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                // Count the consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                // Update longest sequence
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);

        System.out.println("Longest consecutive sequence length: " + result);
        // Output: 4
        // Explanation: The sequence is [1, 2, 3, 4]
    }
}
