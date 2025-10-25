import java.util.*;

public class Find_All_Duplicates_in_Array_442 {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // map number to index (1-indexed array values)

            if (nums[index] < 0) {
                // if already negative, it means this number appeared before
                result.add(index + 1);
            } else {
                // mark as visited by making it negative
                nums[index] = -nums[index];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> duplicates = findDuplicates(nums);
        System.out.println("Duplicate numbers: " + duplicates);
        // Expected Output: [2, 3]
    }
}
