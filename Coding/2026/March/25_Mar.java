// Daily Problem 25th March

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        long total=0;
        for (int[] i:grid)
        {
            for(int j:i)
            {
                total+=j;
            }
        }
        if((total&1)==1)
        {
            return false;
        }
        long target=total/2,sum=0;
        for(int i=0;i<m-1;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum+=grid[i][j];
            }
            if(sum==target)
            {
                return true;
            }
        }
        sum=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<m;j++)
            {
                sum += grid[j][i];
            }
            if(sum==target)
            {
                return true;
            }
        }

        return false;
    }
}