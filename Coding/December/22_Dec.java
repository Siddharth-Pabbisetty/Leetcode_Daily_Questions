// Daily Problem 22nd December

class Solution {
    public int minDeletionSize(String[] strs) {
        int r=strs.length,c=strs[0].length();
        int[] dp=new int[c];

        for(int i=0;i<c;i++)
        {
            dp[i]=1;
        }

        int maxi=1;
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<i;j++)
            {
                boolean valid=true;
                for(int k=0;k<r;k++)
                {
                    if(strs[k].charAt(j)>strs[k].charAt(i))
                    {
                        valid=false;
                        break;
                    }
                }
                if(valid)
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return c-maxi;
    }
}