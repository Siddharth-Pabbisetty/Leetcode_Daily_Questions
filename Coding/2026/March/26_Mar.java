// Daily Problem 26th March

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        long total=0;
        HashMap<Long, Integer> bottom = new HashMap<>();
        HashMap<Long, Integer> top = new HashMap<>();
        HashMap<Long, Integer> left = new HashMap<>();
        HashMap<Long, Integer> right = new HashMap<>();

        for(int[] i:grid)
        {
            for(int j:i)
            {
                total+=j;
                bottom.put((long)j,bottom.getOrDefault((long)j,0)+1);
                right.put((long)j,right.getOrDefault((long)j,0)+1);
            }
        }
        long sumTop=0;
        for(int i=0;i<m-1;i++)
        {
            for(int j=0;j<n;j++)
            {
                int val=grid[i][j];
                sumTop+=val;
                top.put((long)val, top.getOrDefault((long)val, 0) + 1);
                bottom.put((long)val, bottom.get((long)val) - 1);
            }
            long sumBottom=total-sumTop;
            if (sumTop == sumBottom)
            {
                return true;
            }
            long diff=Math.abs(sumTop-sumBottom);
            if(sumTop>sumBottom)
            {
                if(solve(top,grid,0,i,0,n-1,diff))
                {
                    return true;
                }
            }
            else
            {
                if(solve(bottom,grid,i+1,m-1,0,n-1,diff))
                {
                    return true;
                }
            }
        }
        long sumLeft=0;
        for(int j=0;j<n-1;j++)
        {
            for(int i=0;i<m;i++)
            {
                int val=grid[i][j];
                sumLeft+=val;
                left.put((long)val,left.getOrDefault((long)val,0)+1);
                right.put((long)val,right.get((long)val)-1);
            }
            long sumRight=total-sumLeft;

            if(sumLeft==sumRight)
            {
                return true;
            }
            long diff=Math.abs(sumLeft-sumRight);
            if(sumLeft>sumRight)
            {
                if(solve(left,grid,0,m-1,0,j,diff))
                {
                    return true;
                }
            }
            else
            {
                if(solve(right,grid,0,m-1,j+1,n-1,diff))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(HashMap<Long, Integer> mp, int[][] grid, int r1, int r2, int c1, int c2, long diff)
    {
        int rows=r2-r1+1;
        int cols=c2-c1+1;
        if(rows*cols==1)
        {
            return false;
        }
        if(rows==1)
        {
            return grid[r1][c1]==diff || grid[r1][c2]==diff;
        }
        if(cols==1)
        {
            return grid[r1][c1]==diff || grid[r2][c1]==diff;
        }
        return mp.getOrDefault(diff, 0)>0;
    }
}