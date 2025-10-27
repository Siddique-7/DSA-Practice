public class KMP_E_Repeated_Substring_Pattern_459 {

    // Method to check if the string is made by repeating a substring
    public static boolean repeatedSubstringPattern(String s) {
        // Trick: double the string and remove first and last character
        String doubled = s + s;
        // If the original string exists inside (doubled substring),
        // it means the pattern repeats
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }

    // Testing
    public static void main(String[] args) {
        String s1 = "abab";
        System.out.println(repeatedSubstringPattern(s1)); // Output: true

        String s2 = "aba";
        System.out.println(repeatedSubstringPattern(s2)); // Output: false

        String s3 = "abcabcabc";
        System.out.println(repeatedSubstringPattern(s3)); // Output: true
    }
}
