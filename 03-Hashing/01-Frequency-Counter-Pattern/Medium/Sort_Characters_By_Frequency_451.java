import java.util.*;

public class Sort_Characters_By_Frequency_451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree")); // eetr or eert
        System.out.println(frequencySort("cccaaa")); // cccaaa or aaaccc
        System.out.println(frequencySort("Aabb")); // bbAa or bbaA
    }
}
