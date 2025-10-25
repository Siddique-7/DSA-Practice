import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer_13 {

    // Function to convert Roman numeral to integer
    public static int romanToInt(String s) {
        // Map Roman numerals to integer values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = map.get(s.charAt(i));
            int next = (i + 1 < n) ? map.get(s.charAt(i + 1)) : 0;

            // If current is less than next, subtract current
            if (current < next) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }

    // Main method to test
    public static void main(String[] args) {
        String roman1 = "III";    // 3
        String roman2 = "IV";     // 4
        String roman3 = "MCMXCIV"; // 1994

        System.out.println(romanToInt(roman1)); // Output: 3
        System.out.println(romanToInt(roman2)); // Output: 4
        System.out.println(romanToInt(roman3)); // Output: 1994
    }
}
