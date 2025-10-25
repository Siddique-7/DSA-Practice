import java.util.*;

public class Replace_Words_648 {

    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                if (dict.contains(prefix)) {
                    words[i] = prefix;
                    break; // stop at the shortest root
                }
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence)); 
        // Output: "the cat was rat by the bat"
    }
}
