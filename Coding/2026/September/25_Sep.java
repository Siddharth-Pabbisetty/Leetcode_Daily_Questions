// Daily Problem 25th September

class Solution {
    TreeSet<String> ans = new TreeSet<>();
    void solve(String s)
    {
        int r=s.indexOf('}');
        if(r==-1)
        {
            ans.add(s);
            return;
        }
        int l = s.lastIndexOf('{', r);
        String left = s.substring(0, l);
        String right = s.substring(r + 1);
        String inside = s.substring(l + 1, r);
        for (String part : inside.split(","))
        {
            solve(left + part + right);
        }
    }

    public List<String> braceExpansionII(String expression) {
        solve(expression);
        return new ArrayList<>(ans);
    }
}