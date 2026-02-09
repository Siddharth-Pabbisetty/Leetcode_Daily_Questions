// Daily Problem 28th January

class Solution {
    public int minCost(int[][] grid, int k) {
        int n=grid.length, m=grid[0].length;
        int maxi=0;
        for(int[] i:grid)
        {
            for(int j:i)
            {
                maxi=Math.max(maxi,j);
            }
        }
        int[][] dp=new int[n][m];
        int[] temp=new int[maxi+1];
        int[] best=new int[maxi+1];
        Arrays.fill(temp,Integer.MAX_VALUE);
        temp[grid[n-1][m-1]]=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(i==n-1 && j==m-1)
                    continue;
                int down=(i+1 < n) ? dp[i+1][j]+grid[i+1][j] : Integer.MAX_VALUE;
                int right=(j+1<m) ? dp[i][j+1]+grid[i][j+1] : Integer.MAX_VALUE;
                dp[i][j]=Math.min(down,right);
                if(dp[i][j]!=Integer.MAX_VALUE)
                {
                    temp[grid[i][j]]=Math.min(temp[grid[i][j]], dp[i][j]);
                }
            }
        }

        for(int x=0;x<k;x++)
        {
            best[0]=temp[0];
            for(int v=1;v<=maxi;v++)
            {
                best[v]=Math.min(best[v-1],temp[v]);
            }
            for(int i=n-1;i>=0;i--)
            {
                for(int j=m-1;j>=0;j--)
                {
                    if(i==n-1 && j==m-1)
                        continue;
                    int down=(i+1<n) ? dp[i+1][j]+grid[i+1][j] : Integer.MAX_VALUE;
                    int right=(j+1<m) ? dp[i][j+1]+grid[i][j+1] : Integer.MAX_VALUE;
                    int wCost=Math.min(down,right);
                    int tCost=best[grid[i][j]];
                    dp[i][j]=Math.min(wCost, tCost);
                    if(dp[i][j]!=Integer.MAX_VALUE)
                    {
                        temp[grid[i][j]]=Math.min(temp[grid[i][j]],dp[i][j]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}