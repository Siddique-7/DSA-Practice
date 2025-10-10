import java.util.Arrays;

public class Reverse_String_344 {

    // Function to reverse the input character array in-place
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        // Swap characters from both ends moving towards the center
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        char[] str1 = {'h', 'e', 'l', 'l', 'o'};
        char[] str2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        System.out.println("Original: " + Arrays.toString(str1));
        reverseString(str1);
        System.out.println("Reversed: " + Arrays.toString(str1));

        System.out.println("\nOriginal: " + Arrays.toString(str2));
        reverseString(str2);
        System.out.println("Reversed: " + Arrays.toString(str2));
    }
}
