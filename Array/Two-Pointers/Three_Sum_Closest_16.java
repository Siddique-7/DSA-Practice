import java.util.Arrays;

public class Three_Sum_Closest_16 {
    /**
     * Finds the sum of three integers in nums closest to the target.
     */
    
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array for two-pointer approach
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update closestSum if this sum is closer to target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move pointers
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // Exact match
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = threeSumClosest(nums, target);
        System.out.println("Closest sum to " + target + " is: " + result);
    }
}

