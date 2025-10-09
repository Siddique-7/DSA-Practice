import java.util.*;

public class Longest_Repeating_Character_Replacement_424 {

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26]; // frequency of letters in current window
        int maxCount = 0, left = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If replacements needed > k, shrink window
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.print("Enter k (max replacements): ");
        int k = sc.nextInt();

        int result = characterReplacement(s, k);
        System.out.println("Length of longest substring after replacements: " + result);

        sc.close();
    }
}
