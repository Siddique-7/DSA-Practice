public class Remove_Duplicates_from_Sorted_Array_26 {
    // Method to remove duplicates and return the new length
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // pointer for last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { // found a new unique element
                i++;
                nums[i] = nums[j]; // place it next to previous unique
            }
        }
        return i + 1; // new length of array after removing duplicates
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int newLength = removeDuplicates(nums);

        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
