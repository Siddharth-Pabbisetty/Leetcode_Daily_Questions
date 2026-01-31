// Daily Problem 19th January

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length,n=mat[0].length;
        int maxi=Math.min(m,n);
        int[][] arr=new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                arr[i][j] = mat[i-1][j-1]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }

        while(maxi>0)
        {
            for(int i=0;i+maxi<=m;i++)
            {
                for (int j=0;j+maxi<=n;j++)
                {
                    if(solve(arr,threshold,i,j,maxi))
                    {
                        return maxi;
                    }
                }
            }
            maxi--;
        }
        return 0;
    }

    private boolean solve(int[][] arr,int t,int x,int y,int side)
    {
        int x1=x+side;
        int y1=y+side;
        int sum = arr[x1][y1]-arr[x][y1]-arr[x1][y]+arr[x][y];
        return sum<=t;
    }

}