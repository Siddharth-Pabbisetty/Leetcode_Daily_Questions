//Daily problem of 13th october

class Solution {
    public List<String> removeAnagrams(String[] words) {
        int l = words.length;
        List<Map<Character, Integer>> freq = new ArrayList<>();
        for(String i:words)
        {
            Map<Character,Integer> mp = new HashMap<>();
            for(char ch:i.toCharArray())
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            freq.add(mp);
        }

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<l;i++)
        {
            if(!freq.get(i).equals(freq.get(i - 1)))
                ans.add(words[i]);
        }
        return ans;
    }
}