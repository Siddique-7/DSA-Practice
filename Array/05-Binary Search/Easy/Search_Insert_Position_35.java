public class Search_Insert_Position_35 {

    // Function to find the index where target should be inserted
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        // If not found, left is the insertion position
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("Insert position: " + searchInsert(nums, target)); // Output: 2

        target = 2;
        System.out.println("Insert position: " + searchInsert(nums, target)); // Output: 1

        target = 7;
        System.out.println("Insert position: " + searchInsert(nums, target)); // Output: 4

        target = 0;
        System.out.println("Insert position: " + searchInsert(nums, target)); // Output: 0
    }
}
