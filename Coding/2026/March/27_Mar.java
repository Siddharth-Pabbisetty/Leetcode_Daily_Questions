// Daily Problem 27th March

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int r=mat.length;
        int c=mat[0].length;
        k %=c;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i%2==0)
                {
                    if(mat[i][j]!=mat[i][(j+k)%c])
                    {
                        return false;
                    }
                }
                else
                {
                    if (mat[i][j]!=mat[i][(j-k+c)%c])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}