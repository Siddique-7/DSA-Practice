public class KMP_E_Find_Index_of_First_Occurrence_28 {

    // Method to find the first occurrence of needle in haystack
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Edge case
        if (m == 0) return 0;

        // Simple sliding window approach
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // Found the first occurrence
            }
        }

        return -1; // Not found
    }

    // Testing
    public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(haystack1, needle1)); // Output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2)); // Output: -1
    }
}
