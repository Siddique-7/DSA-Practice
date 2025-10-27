public class KMP_H_Longest_Happy_Prefix_1392 {
    public static String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // current length of the longest prefix-suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // The last value of LPS represents the longest happy prefix length
        return s.substring(0, lps[n - 1]);
    }

        public static void main(String[] args) {
        String s = "level";
        System.out.println(longestPrefix(s));  // Output: "l"
    }
}
