// Daily Problem 22nd March

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int l=mat.length;
        int m=0b1111;
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<l;j++)
            {
                if(mat[i][j] != target[i][j])
                {
                    m&=0b1110;
                }
                if(mat[i][j] != target[j][l-1-i])
                {
                    m&=0b1101;
                }
                if(mat[i][j] != target[l-1-i][l-1-j])
                {
                    m&=0b1011;
                }
                if(mat[i][j] != target[l-1-j][i])
                {
                    m&=0b0111;
                }
                if(m==0)
                    return false;
            }
        }
        return m!=0;
    }
}