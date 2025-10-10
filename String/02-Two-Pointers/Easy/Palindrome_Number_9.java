public class Palindrome_Number_9 {

    // Function to check if a number is a palindrome
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        // Numbers ending with 0 (but not 0 itself) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse half of the number
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // Check if the original number equals reversed
        return original == reversed;
    }

    // Main method for testing
    public static void main(String[] args) {
        int num1 = 121;
        int num2 = -121;
        int num3 = 10;

        System.out.println(num1 + " → " + isPalindrome(num1)); // true
        System.out.println(num2 + " → " + isPalindrome(num2)); // false
        System.out.println(num3 + " → " + isPalindrome(num3)); // false
    }
}
