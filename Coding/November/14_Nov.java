// Daily Problem 14th November

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for(int[] q : queries)
        {
            int r1=q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];
            diff[r1][c1]++;
            diff[r2+1][c1]--;
            diff[r1][c2+1]--;
            diff[r2+1][c2+1]++;
        }

        int[][] ans = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up = i>0 ? ans[i-1][j] : 0;
                int l = j>0 ? ans[i][j-1] : 0;
                int dg = (i>0 && j>0) ? ans[i-1][j-1] : 0;
                ans[i][j] = diff[i][j]+up+l-dg;
            }
        }

        return ans;
    }
}

