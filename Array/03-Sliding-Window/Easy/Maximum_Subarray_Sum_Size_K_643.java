import java.util.*;

public class Maximum_Subarray_Sum_Size_K_643 {

    public static int maxSumSubarray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i]; // add current element to window

            if (i >= k - 1) { // window size reached k
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i - k + 1]; // remove element leaving the window
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter subarray size k: ");
        int k = sc.nextInt();

        int result = maxSumSubarray(nums, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);

        sc.close();
    }
}
