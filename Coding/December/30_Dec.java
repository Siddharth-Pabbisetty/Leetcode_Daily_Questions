// Daily Problem 30th December

class Solution {
    public boolean solve(int[][] mat,int r,int c){
        int sum=mat[r][c]+mat[r][c+1]+mat[r][c+2];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                int num=mat[r+i][c+j];
                if(num<1 || num>9 || set.contains(num))
                    return false;
                set.add(num);
            }
        }

        for(int i=0;i<3;i++)
        {
            if((mat[r][c+i]+mat[r+1][c+i]+mat[r+2][c+i])!=sum)
                return false;
            if(mat[r+i][c]+mat[r+i][c+1]+mat[r+i][c+2]!=sum)
                return false;
        }
        if((mat[r][c]+mat[r+1][c+1]+mat[r+2][c+2])!=sum)
            return false;
        if(mat[r][c+2]+mat[r+1][c+1]+mat[r+2][c]!=sum)
            return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int cnt=0;
        for(int i=0;i<=m-3;i++)
        {
            for(int j=0;j<=n-3;j++)
            {
                if(solve(grid,i,j))
                    cnt++;
            }
        }
        return cnt;
    }
}