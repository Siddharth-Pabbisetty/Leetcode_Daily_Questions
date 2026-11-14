// Daily Problem 26th October

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]>0)
                {
                    long val=solve(grid,i,j);
                    if(val%k==0)
                    {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private long solve(int[][] grid,int i,int j)
    {
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)
        {
            return 0;
        }
        long sum=grid[i][j];
        grid[i][j]=0;
        sum+=solve(grid,i+1,j);
        sum+=solve(grid,i-1,j);
        sum+=solve(grid,i,j+1);
        sum+=solve(grid,i,j-1);
        return sum;
    }
}