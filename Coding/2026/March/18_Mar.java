// Daily Problem 18th March

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int r=grid.length, c=grid[0].length;
        int ans=0;
        int[][] arr=new int[r+1][c+1];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                arr[i+1][j+1]=grid[i][j]+arr[i][j+1]+arr[i+1][j]-arr[i][j];
                if(arr[i+1][j+1]<=k)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}