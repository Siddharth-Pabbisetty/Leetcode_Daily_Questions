// Daily Problem 18th January

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n<2 || m<2)
            return 1;
        long[][] r1=new long[n][m+1];
        long[][] c1=new long[n+1][m];
        long[][] r2=new long[n+1][m+2];
        long[][] c2=new long[n+1][m+2];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                r1[i][j+1] = r1[i][j]+grid[i][j];
                c1[i+1][j] = c1[i][j]+grid[i][j];
                r2[i+1][j+1] = r2[i][j]+grid[i][j];
                c2[i+1][j] = c2[i][j+1]+grid[i][j];
            }
        }

        for(int i=Math.min(n,m);i>1;i--)
        {
            for(int j=0;j<=n-i;j++)
            {
                for(int k=0;k<=m-i;k++)
                {
                    long ans=r1[j][k+i]-r1[j][k];
                    if(r2[j+i][k+i]-r2[j][k] != ans)
                        continue;
                    if(c2[j+i][k]-c2[j][k+i] != ans)
                        continue;

                    boolean flag=true;
                    for(int z=0;z<i;z++)
                    {
                        if(r1[j+z][k+i]-r1[j+z][k] != ans)
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(!flag)
                        continue;

                    for(int z=0;z<i;z++)
                    {
                        if (c1[j+i][k+z]-c1[j][k+z] != ans)
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)
                        return i;
                }
            }
        }
        return 1;
    }
}