public class Merge_Sorted_Array_88 {
    // Method to merge two sorted arrays in-place
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // last element in nums1's initialized part
        int j = n - 1;        // last element in nums2
        int k = m + n - 1;    // last position in nums1 (final merged array)

        // Start merging from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has remaining elements
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
