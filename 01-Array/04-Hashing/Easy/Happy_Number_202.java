import java.util.HashSet;
import java.util.Set;

public class Happy_Number_202 {

    // Function to check if a number is happy
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    // Helper function to calculate sum of squares of digits
    private static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num1 = 19;
        int num2 = 2;

        System.out.println(num1 + " is happy? " + isHappy(num1)); // true
        System.out.println(num2 + " is happy? " + isHappy(num2)); // false
    }
}
