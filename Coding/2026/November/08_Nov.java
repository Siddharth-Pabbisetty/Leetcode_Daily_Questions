// Daily Problem 8th November

class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] r=new int[m];
        int[] c=new int[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                r[i]+=grid[i][j];
                c[j]+=grid[i][j];
            }
        }
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && r[i]+c[j]>2)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}