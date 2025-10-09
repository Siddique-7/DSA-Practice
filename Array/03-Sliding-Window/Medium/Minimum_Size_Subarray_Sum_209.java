import java.util.Scanner;

public class Minimum_Size_Subarray_Sum_209 {

    // Function to find the minimal length of a contiguous subarray
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        // Sliding window approach
        for (int right = 0; right < n; right++) {
            sum += nums[right]; // expand the window
            while (sum >= target) { // shrink the window from the left
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum length of subarray: " + result);
        
        sc.close();
    }
}
