import java.util.Stack;

public class Simplify_Path_71 {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        String path1 = "/home/";
        String path2 = "/../";
        String path3 = "/home//foo/";

        System.out.println(simplifyPath(path1)); // Output: /home
        System.out.println(simplifyPath(path2)); // Output: /
        System.out.println(simplifyPath(path3)); // Output: /home/foo
    }
}
