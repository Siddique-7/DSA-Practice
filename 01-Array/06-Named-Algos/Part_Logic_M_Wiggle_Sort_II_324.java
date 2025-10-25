import java.util.Arrays;

public class Part_Logic_M_Wiggle_Sort_II_324 {

    public static void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = nums.length;
        int mid = (n - 1) / 2; // middle for smaller half
        int end = n - 1;       // end for larger half

        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? sorted[mid--] : sorted[end--];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); 
        // Output: [1,6,1,5,1,4] or any valid wiggle arrangement
    }
}
