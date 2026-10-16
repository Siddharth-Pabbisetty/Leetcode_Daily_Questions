// Daily Problem 28th September

class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int ans=0;
        for(char ch:s.toCharArray())
        {
            if(ch==')')
            {
                depth--;
                continue;
            }
            if(ch!='(')
            {
                continue;
            }
            depth++;
            if(depth>ans)
            {
                ans=depth;
            }
        }
        return ans;
    }
}