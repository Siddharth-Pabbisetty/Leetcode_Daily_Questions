// Daily Problem 17th March

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        int ans=0;
        for(int i=1;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(matrix[i][j]==1)
                {
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }
        for(int i=0;i<r;i++)
        {
            Arrays.sort(matrix[i]);
            for(int j=0;j<c;j++)
            {
                ans=Math.max(ans,matrix[i][j]*(c-j));
            }
        }
        return ans;
    }
}