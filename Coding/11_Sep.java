//Daily Problem 10th September

import java.util.*;

class Solution {
    public String sortVowels(String s) {
        Set<Character> v = new HashSet<>(
                Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );

        List<Character> ls = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (v.contains(c)) {
                ls.add(c);
            }
        }
        Collections.sort(ls);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (v.contains(c)) {
                ans.append(ls.get(i++));
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}