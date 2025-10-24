import java.util.*;

public class Minimum_Window_Substring_76 {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Frequency map for characters in t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Two pointers for sliding window
        int left = 0, right = 0;
        int required = need.size(); // Number of unique chars we need to match
        int formed = 0; // Number of chars that currently satisfy the need
        Map<Character, Integer> windowCounts = new HashMap<>();

        // [start, end] will store the smallest valid window
        int[] ans = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If this char's count matches the target count, we have a match
            if (need.containsKey(c) && windowCounts.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left if it’s valid
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save smallest window so far
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the leftmost character and update counts
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (need.containsKey(c) && windowCounts.get(c).intValue() < need.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand the window to the right
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    // Example test cases
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Output 1: " + minWindow(s1, t1)); // Output: "BANC"

        String s2 = "a";
        String t2 = "a";
        System.out.println("Output 2: " + minWindow(s2, t2)); // Output: "a"

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Output 3: " + minWindow(s3, t3)); // Output: ""
    }
}
