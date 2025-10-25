import java.util.Stack;

public class Decode_String_394 {

    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String result = "";
        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (c == '[') {
                resultStack.push(result);
                result = "";
                index++;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeat = counts.pop();
                for (int i = 0; i < repeat; i++) {
                    temp.append(result);
                }
                result = temp.toString();
                index++;
            } else {
                result += c;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";      // Output: "aaabcbc"
        String s2 = "3[a2[c]]";       // Output: "accaccacc"
        String s3 = "2[abc]3[cd]ef";  // Output: "abcabccdcdcdef"

        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
    }
}
