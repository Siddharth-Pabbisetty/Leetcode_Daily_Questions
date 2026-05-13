// Daily Problem 26th April

class Solution {
    static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[] b=new boolean[m*n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!b[i*n+j] && dfs(i,j,-1,-1,grid,b,m,n))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[] b, int m, int n) {
        b[r*n+c]=true;
        for(int[] i:dirs)
        {
            int nr=r+i[0];
            int nc=c+i[1];
            if(nr!=pr || nc!=pc)
            {
                if(nr>=0 && nr<m && nc>=0 && nc<n)
                {
                    if(grid[nr][nc]==grid[r][c])
                    {
                        if(b[nr*n+nc] || dfs(nr,nc,r,c,grid,b,m,n))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}