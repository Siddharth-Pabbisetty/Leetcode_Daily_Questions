// Daily Problem 5th October

class Solution {
    public int scoreOfParentheses(String s) {
        return solve(s,0,s.length());
    }

    private int solve(String s,int i,int j)
    {
        int res=0,bal=0;
        for(int k=i;k<j;k++)
        {
            bal+=s.charAt(k)=='('?1:-1;
            if(bal==0)
            {
                if(k-i==1)
                {
                    res++;
                }
                else
                {
                    res+=2*solve(s,i+1,k);
                }
                i=k+1;
            }
        }
        return res;
    }
}