public class Reverse_Words_in_a_String_151 {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";

        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        // Reverse the array of words
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" "); // Add space between words
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println("Output 1: \"" + reverseWords(s1) + "\""); // "blue is sky the"

        String s2 = "  hello world!  ";
        System.out.println("Output 2: \"" + reverseWords(s2) + "\""); // "world! hello"

        String s3 = "a good   example";
        System.out.println("Output 3: \"" + reverseWords(s3) + "\""); // "example good a"
    }
}
