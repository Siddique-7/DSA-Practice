import java.util.*;

public class Two_Sum_II_167 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Not found
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(numbers1, target1))); // Expected: [1, 2]

        int[] numbers2 = {1, 2, 3, 4, 4, 9, 56, 90};
        int target2 = 8;
        System.out.println(Arrays.toString(twoSum(numbers2, target2))); // Expected: [4, 5]

        int[] numbers3 = {1, 3, 4, 5, 7, 11, 15};
        int target3 = 10;
        System.out.println(Arrays.toString(twoSum(numbers3, target3))); // Expected: [2, 5]
    }
}

