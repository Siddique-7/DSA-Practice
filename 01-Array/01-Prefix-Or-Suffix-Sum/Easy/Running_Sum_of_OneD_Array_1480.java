public class Running_Sum_of_OneD_Array_1480 {

    // Function to calculate running sum
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        // Each element = previous sum + current number
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }

    // Main method for testing locally
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = runningSum(nums);

        // Print output
        System.out.print("Running Sum: ");
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
