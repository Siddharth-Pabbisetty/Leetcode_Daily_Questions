// Daily Problem 5th January

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        long total=0;
        int cnt=0;
        int mini=Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int val=matrix[i][j];
                total+=Math.abs(val);
                if(val<0)
                {
                    cnt++;
                }
                mini=Math.min(mini,Math.abs(val));
            }
        }
        if (cnt%2==0)
        {
            return total;
        }
        else
        {
            return total-2*mini;
        }
    }
}