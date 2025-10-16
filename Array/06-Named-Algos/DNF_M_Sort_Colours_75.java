// LeetCode 75: Sort Colors
// Problem: Sort an array of 0s, 1s, and 2s in-place using the Dutch National Flag algorithm.

public class DNF_M_Sort_Colours_75 {

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 to the beginning
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Leave 1 in the middle
                mid++;
            } else {
                // Swap 2 to the end
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int n : nums) System.out.print(n + " ");
        // Output: 0 0 1 1 2 2
    }
}
