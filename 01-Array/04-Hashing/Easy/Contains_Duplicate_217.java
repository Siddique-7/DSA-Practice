import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_217 {

    // Function to check if array contains duplicates
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println("nums1 contains duplicates? " + containsDuplicate(nums1)); // false
        System.out.println("nums2 contains duplicates? " + containsDuplicate(nums2)); // true
    }
}
