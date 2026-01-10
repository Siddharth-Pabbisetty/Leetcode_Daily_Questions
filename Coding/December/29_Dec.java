// Daily Problem 29th December

class Solution {
    Map<String, List<Character>> mp = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s:allowed)
        {
            String key=s.substring(0,2);
            mp.computeIfAbsent(key,k -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom);
    }

    private boolean solve(String bottom)
    {
        if(bottom.length()==1)
            return true;
        if(memo.containsKey(bottom))
            return memo.get(bottom);
        boolean res=generateNextRow(bottom, 0, new StringBuilder());
        memo.put(bottom,res);
        return res;
    }

    private boolean generateNextRow(String bottom, int idx, StringBuilder curr)
    {
        if(idx==bottom.length()-1)
        {
            return solve(curr.toString());
        }
        String key=bottom.substring(idx,idx+2);
        if (!mp.containsKey(key))
            return false;
        for(char ch:mp.get(key))
        {
            curr.append(ch);
            if(generateNextRow(bottom,idx+1,curr))
                return true;
            curr.deleteCharAt(curr.length() - 1);
        }
        return false;
    }
}