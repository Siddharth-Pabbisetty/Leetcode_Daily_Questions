// Daily Problem 23rd March

class Solution {
    public int maxProductPath(int[][] grid) {
        int r=grid.length, c=grid[0].length;
        long MOD=1000000007;

        long[][] maxi = new long[r][c];
        long[][] mini = new long[r][c];

        maxi[0][0]=mini[0][0]=grid[0][0];

        for(int i=1;i<c;i++)
        {
            maxi[0][i]=mini[0][i]=maxi[0][i-1]*grid[0][i];
        }

        for(int i=1;i<r;i++)
        {
            maxi[i][0]=mini[i][0]=maxi[i-1][0]*grid[i][0];
        }

        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                long val=grid[i][j];
                long a=maxi[i-1][j]*val;
                long b=mini[i-1][j]*val;
                long c_val=maxi[i][j-1]*val;
                long d=mini[i][j-1]*val;
                maxi[i][j]=Math.max(Math.max(a,b), Math.max(c_val,d));
                mini[i][j]=Math.min(Math.min(a,b), Math.min(c_val,d));
            }
        }

        long ans=maxi[r-1][c-1];
        if(ans<0)
        {
            return -1;
        }
        return (int)(ans%MOD);
    }
}