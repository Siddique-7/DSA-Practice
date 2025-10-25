public class Remove_Element_27 {
    // Method to remove all occurrences of 'val' and return new length
    public static int removeElement(int[] nums, int val) {
        int i = 0; // pointer for valid (non-val) elements

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {   // if current element is not equal to val
                nums[i] = nums[j];  // move it to the front
                i++;                // increment valid element counter
            }
        }
        return i; // 'i' is the new length after removal
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int newLength = removeElement(nums, val);

        System.out.println("New length: " + newLength);
        System.out.print("Array after removing " + val + ": ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
