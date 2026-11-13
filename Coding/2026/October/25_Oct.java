// Daily Problem 25th October

class Solution {
    private int[][] grid;
    private int m, n;

    private boolean solve(int i, int j)
    {
        if(i<0 || i>=m || j<0 || j>=n)
        {
            return false;
        }
        if(grid[i][j]==1)
        {
            return true;
        }
        grid[i][j]=1;
        return solve(i+1,j) & solve(i-1,j) & solve(i,j+1) & solve(i,j-1);
    }

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0 && solve(i,j))
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}