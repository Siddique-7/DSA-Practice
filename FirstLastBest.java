public class FirstLastBest {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        
        int firstPos = lowerBound(nums, target);
        if (firstPos == -1) return new int[]{-1, -1}; // If not found, return [-1, -1]
        
        int lastPos = upperBound(nums, target);
        return new int[]{firstPos, lastPos};
    }

    public int lowerBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int ans = -1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] >= target) {  // Keep searching left if nums[mid] == target
                if (nums[mid] == target) ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public int upperBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int ans = -1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= target) {  // Keep searching right if nums[mid] == target
                if (nums[mid] == target) ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

}
