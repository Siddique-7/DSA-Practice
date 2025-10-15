import java.util.*;

public class Split_Array_Largest_Sum_410 {

    public static int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }

        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1, currentSum = 0;
        for (int n : nums) {
            if (currentSum + n > maxSum) {
                currentSum = n;
                count++;
                if (count > k) return false;
            } else {
                currentSum += n;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println("Minimum largest sum: " + splitArray(nums, k)); // Output: 18
    }
}
