// Daily Problem 21st March

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int l=x;
        int r=x+k-1;
        while(l<r)
        {
            for(int j=y;j<y+k;j++)
            {
                int temp=grid[l][j];
                grid[l][j]=grid[r][j];
                grid[r][j]=temp;
            }
            l++;
            r--;
        }
        return grid;
    }
}