// Daily Problem 14th February

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[102][102];
        arr[0][0] = (double) poured;
        for(int r=0;r<=query_row;r++)
        {
            for(int c=0;c<=r;c++)
            {
                if(arr[r][c]>1.0)
                {
                    double excess=(arr[r][c]-1.0)/2.0;
                    arr[r][c] =1.0;
                    arr[r+1][c]+=excess;
                    arr[r+1][c+1]+=excess;
                }
            }
        }
        return arr[query_row][query_glass];
    }
}