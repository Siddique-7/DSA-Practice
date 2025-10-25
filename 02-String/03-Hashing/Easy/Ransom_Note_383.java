public class Ransom_Note_383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; // count letters in magazine

        for (char c : magazine.toCharArray()) count[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false; // not enough letters
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); // false
        System.out.println(canConstruct("aa", "ab")); // false
        System.out.println(canConstruct("aa", "aab")); // true
    }
}
