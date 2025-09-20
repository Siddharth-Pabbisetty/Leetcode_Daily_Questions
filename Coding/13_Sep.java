//Daily Problem 13th September

import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int c=0, v=0;
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> i : mp.entrySet()) {
            char ch = i.getKey();
            int cnt = i.getValue();
            if ("aeiou".indexOf(ch) >= 0)
                v=Math.max(v,cnt);
            else
                c=Math.max(c,cnt);
        }
        return c+v;
    }
}
