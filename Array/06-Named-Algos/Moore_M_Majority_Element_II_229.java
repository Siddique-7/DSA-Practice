// LeetCode 229: Majority Element II
// Problem: Find all elements appearing more than n/3 times in an array.

import java.util.*;

public class Moore_M_Majority_Element_II_229 {

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1; // initialize differently to handle edge cases

        // 1st pass: find potential candidates
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums)); // Output: [3]

        int[] nums2 = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums2)); // Output: [1,2]
    }
}
