public class Binary_Search_704 {

    // Standard binary search implementation
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("Index of target: " + search(nums, target)); // Output: 4

        target = 2;
        System.out.println("Index of target: " + search(nums, target)); // Output: -1
    }
}
