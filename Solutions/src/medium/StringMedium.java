package medium;

import java.util.*;

public class StringMedium {


    /*TODO Is Isomorphic Strings*/
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> charToIndex_s = new HashMap<>();
        Map<Character, Integer> charToIndex_t = new HashMap<>();

        for (Integer i = 0; i < s.length(); ++i)
            if (charToIndex_s.put(s.charAt(i), i) != charToIndex_t.put(t.charAt(i), i))
                return false;

        return true;
    }

    public String frequencySort(String s) {

        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder ans = new StringBuilder();
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            int freq = entry.getValue();
            char ch = entry.getKey();

            while (freq-- > 0) {
                ans.append(ch);
            }
        }
        return ans.toString();

    }


}
