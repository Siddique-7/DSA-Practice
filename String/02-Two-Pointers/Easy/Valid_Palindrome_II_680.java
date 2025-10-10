public class Valid_Palindrome_II_680 {

    // Function to check if the string can be a palindrome after deleting at most one character
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either the left character or the right character
                return isPalindromeRange(s, left + 1, right) || isPalindromeRange(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true; // Already a palindrome
    }

    // Helper function to check if substring s[left...right] is a palindrome
    private static boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";

        System.out.println(s1 + " → " + validPalindrome(s1)); // true
        System.out.println(s2 + " → " + validPalindrome(s2)); // true
        System.out.println(s3 + " → " + validPalindrome(s3)); // false
    }
}
