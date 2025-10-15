public class First_Bad_Version_278 {

    // Simulating the API provided by LeetCode
    static boolean isBadVersion(int version) {
        int firstBad = 4; // example: version 4 and after are bad
        return version >= firstBad;
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid; // search left half
            else left = mid + 1; // search right half
        }
        return left; // first bad version
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("First bad version: " + firstBadVersion(n)); // Output: 4
    }
}
