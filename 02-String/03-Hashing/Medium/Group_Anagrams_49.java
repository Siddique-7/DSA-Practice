import java.util.*;

public class Group_Anagrams_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map from sorted string to list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // sort characters to get key
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // Output: [[""]]

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
        // Output: [["a"]]
    }
}
