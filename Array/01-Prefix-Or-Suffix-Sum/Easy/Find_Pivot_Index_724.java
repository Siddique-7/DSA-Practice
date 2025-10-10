public class Find_Pivot_Index_724 {

    // Function to find pivot index
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;   // Sum of all elements
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;    // Sum of elements to the left
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;   // Pivot found
            }
            leftSum += nums[i];
        }

        return -1;          // No pivot exists
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivot = pivotIndex(nums);
        System.out.println("Pivot Index: " + pivot);  // Output: 3
    }
}
