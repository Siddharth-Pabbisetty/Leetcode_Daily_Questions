// Daily Problem 9th August

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n+1];
        int[] suffixSum=new int[n];
        suffixSum[n-1]=piles[n-1];
        for(int i=n-2;i>=0;i--)
        {
            suffixSum[i]=suffixSum[i+1]+piles[i];
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=1;j<=n;j++)
            {
                if(i+2*j>=n)
                {
                    dp[i][j]=suffixSum[i];
                }
                else
                {
                    for(int k=1;k<=2*j;k++)
                    {
                        dp[i][j]=Math.max(dp[i][j],suffixSum[i]-dp[i+k][Math.max(j,k)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}