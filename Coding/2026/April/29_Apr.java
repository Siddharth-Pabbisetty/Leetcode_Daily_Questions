// Daily Problem 29th April

class Solution {
    public long maximumScore(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(m==1)
        {
            return 0;
        }
        long[][] col=new long[m][n+1];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                col[i][j+1]=col[i][j]+grid[j][i];
            }
        }
        long[][] dp=new long[n+1][n+1];
        long[][] prefixMax=new long[n+1][n+1];
        long[][] suffixMax=new long[n+1][n+1];
        for(int i=1;i<m;i++)
        {
            long[][] newdp=new long[n+1][n+1];
            for(int j=0;j<=n;j++)
            {
                for(int k=0;k<=n;k++)
                {
                    if(j<=k)
                    {
                        long gain=col[i][k]-col[i][j];
                        newdp[j][k]=Math.max(newdp[j][k],suffixMax[k][0] + gain);
                    }
                    else
                    {
                        long gain=col[i-1][j]-col[i-1][k];
                        newdp[j][k]=Math.max(newdp[j][k],Math.max(suffixMax[k][j],prefixMax[k][j]+gain));
                    }
                }
            }
            for(int j=0;j<=n;j++)
            {
                prefixMax[j][0]=newdp[j][0];
                for(int k=1;k<=n;k++)
                {
                    long penalty=0;
                    if(k>j)
                    {
                        penalty = col[i][k]-col[i][j];
                    }
                    prefixMax[j][k]=Math.max(prefixMax[j][k-1],newdp[j][k]-penalty);
                }
                suffixMax[j][n]=newdp[j][n];
                for(int k=n-1;k>=0;k--)
                {
                    suffixMax[j][k]=Math.max(suffixMax[j][k+1],newdp[j][k]);
                }
            }
            dp=newdp;
        }
        long ans=0;
        for(int i=0;i<=n;i++)
        {
            ans=Math.max(ans,Math.max(dp[0][i],dp[n][i]));
        }
        return ans;
    }
}