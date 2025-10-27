public class KMP_H_Shortest_Palindrome_214 {

    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev; // Combine original and reversed with separator
        int[] lps = computeLPS(combined); // Build KMP table
        int len = lps[lps.length - 1]; // Length of longest prefix that is also suffix
        // Add the remaining reversed part in front
        return rev.substring(0, rev.length() - len) + s;
    }

    // Compute the LPS (Longest Prefix Suffix) array for KMP
    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

        public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));  // Output: aaacecaaa
    }

}
