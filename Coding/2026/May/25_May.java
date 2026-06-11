// Daily Problem 25th May

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1)=='1')
        {
            return false;
        }
        int[] dp=new int[n];
        dp[0]=1;
        int val=0,maxi=maxJump;
        for(int i=minJump;i<n;i++)
        {
            if(i>maxi)
            {
                return false;
            }
            val+=dp[i-minJump];
            if(i>maxJump)
            {
                val-=dp[i-maxJump-1];
            }
            if(val>0 && s.charAt(i)=='0')
            {
                dp[i]=1;
                maxi=i+maxJump;
            }
        }
        return val>0;
    }
}