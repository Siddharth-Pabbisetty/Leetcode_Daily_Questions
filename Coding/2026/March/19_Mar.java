// Daily Problem 19th March

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int r=grid.length, c=grid[0].length;
        int[] sumX = new int[c];
        int[] sumY = new int[c];
        int ans=0;
        for(int i=0;i<r;i++)
        {
            int rx = 0, ry = 0;
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='X')
                {
                    rx++;
                }
                else if(grid[i][j]=='Y')
                {
                    ry++;
                }
                sumX[j] += rx;
                sumY[j] += ry;
                if(sumX[j]>0 && sumX[j]==sumY[j])
                {
                    ans++;
                }
            }
        }

        return ans;
    }
}