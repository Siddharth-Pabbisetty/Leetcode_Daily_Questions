// Daily Problem 30th April

import java.util.*;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int NEG=-1_000_000_000;
        int[][] prev=new int[n][k+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(prev[i],NEG);
        }
        for (int i = 0; i < m; i++)
        {
            int[][] curr=new int[n][k+1];
            for(int j=0;j<n;j++)
            {
                Arrays.fill(curr[j], NEG);
            }
            for(int j=0;j<n;j++)
            {
                int gain=grid[i][j];
                int need=gain>0?1:0;
                int limit = Math.min(k,i+j);
                if (i == 0 && j == 0)
                {
                    curr[0][0] = 0;
                    continue;
                }
                for (int c = need; c <= limit; c++)
                {
                    int best=NEG;
                    if(i>0 && prev[j][c - need] != NEG)
                    {
                        best = Math.max(best, prev[j][c - need] + gain);
                    }
                    if (j > 0 && curr[j - 1][c - need] != NEG)
                    {
                        best = Math.max(best, curr[j - 1][c - need] + gain);
                    }
                    curr[j][c] = best;
                }
            }
            prev = curr;
        }
        int ans = NEG;
        for(int i=0;i<=k;i++)
        {
            ans=Math.max(ans,prev[n-1][i]);
        }
        return ans < 0 ? -1 : ans;
    }
}