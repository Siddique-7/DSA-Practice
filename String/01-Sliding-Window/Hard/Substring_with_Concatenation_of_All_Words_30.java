import java.util.*;

public class Substring_with_Concatenation_of_All_Words_30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowSize = wordLen * wordCount;

        // Frequency map for words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words)
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);

        // We iterate from each possible starting index (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more than needed, shrink from left
                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If we matched all words, record index
                    if (count == wordCount) {
                        result.add(left);
                        // Move left to find new possible window
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    // Reset if word not in list
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println("Output 1: " + findSubstring(s1, words1)); // [0, 9]

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println("Output 2: " + findSubstring(s2, words2)); // []

        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println("Output 3: " + findSubstring(s3, words3)); // [6, 9, 12]
    }
}
