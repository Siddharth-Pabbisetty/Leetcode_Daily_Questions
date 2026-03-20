// Daily Problem 9th March

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD=1000000007;
        int len=limit+1;
        int[][] dp=new int[zero+1][one+1];
        int[][] dp1=new int[zero+1][one+1];

        for(int i=1;i<=Math.min(zero,limit);i++)
        {
            dp[i][0]=1;
        }
        for(int j=1;j<=Math.min(one,limit);j++)
        {
            dp1[0][j] = 1;
        }

        for(int i=1;i<=zero;i++)
        {
            for(int j=1;j<=one;j++)
            {
                dp[i][j]=(dp[i-1][j]+dp1[i-1][j]-(i>=len?dp1[i-len][j]:0))%MOD;
                dp1[i][j]=(dp1[i][j-1]+dp[i][j-1]-(j>=len?dp[i][j-len]:0))%MOD;
                dp[i][j]=(dp[i][j]+MOD)%MOD;
                dp1[i][j]=(dp1[i][j]+MOD)%MOD;
            }
        }

        return (dp[zero][one]+dp1[zero][one])%MOD;
    }
}