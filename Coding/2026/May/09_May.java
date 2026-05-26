// Daily Problem 9th May

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int total=0,l=0;
        int r=grid.length-1,c=grid[0].length-1;
        while(total<r && l<c)
        {
            int len=r-total,wid=c-l;
            int perimeter=2*len+2*wid;
            int m=k%perimeter;
            while(m-->0)
            {
                int tmp = grid[total][l];
                for(int i=l;i<c;i++)
                {
                    grid[total][i]=grid[total][i+1];
                }
                for(int i=total;i<r;i++)
                {
                    grid[i][c]=grid[i+1][c];
                }
                for(int i=c;i>l;i--)
                {
                    grid[r][i]=grid[r][i-1];
                }
                for(int i=r;i>total;i--)
                {
                    grid[i][l]=grid[i-1][l];
                }
                grid[total+1][l]=tmp;
            }
            total++;
            l++;
            r--;
            c--;
        }

        return grid;
    }
}