// LeetCode 169: Majority Element
// Problem: Find the element that appears more than n/2 times in an array.

public class Moore_E_Majority_Element_169 {

    // Moore's Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0, candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // choose new candidate
            }
            count += (num == candidate) ? 1 : -1;  // increment if same, else decrement
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));  // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2)); // Output: 2
    }
}
