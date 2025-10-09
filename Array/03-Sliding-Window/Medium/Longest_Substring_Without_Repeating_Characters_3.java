import java.util.*;

public class Longest_Substring_Without_Repeating_Characters_3{

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // Move left pointer to the right of last occurrence
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);

        sc.close();
    }
}
