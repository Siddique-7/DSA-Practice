public class Find_Peak_Element_162 {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        System.out.println("Peak Index: " + findPeakElement(nums1)); // Output: 2

        int[] nums2 = {1,2,1,3,5,6,4};
        System.out.println("Peak Index: " + findPeakElement(nums2)); // Output: 1 or 5

        int[] nums3 = {1};
        System.out.println("Peak Index: " + findPeakElement(nums3)); // Output: 0
    }
}
