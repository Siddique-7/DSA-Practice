import java.util.*;

public class Permutation_in_String_567 {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26]; // Frequency of chars in s1
        int[] s2Count = new int[26]; // Frequency of current window in s2

        // Fill frequency for s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            // Add current char to window count
            s2Count[s2.charAt(i) - 'a']++;

            // Remove the char that's out of the window
            if (i >= windowSize) {
                s2Count[s2.charAt(i - windowSize) - 'a']--;
            }

            // Check if window matches s1 frequency
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);
        System.out.println("Result: " + result); // true
    }
}
