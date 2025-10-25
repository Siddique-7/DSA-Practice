public class Trapping_Rain_Water_42 {
    // Method to calculate total trapped water
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};

        int result = trap(height);

        System.out.println("Total trapped water: " + result);
    }
}
