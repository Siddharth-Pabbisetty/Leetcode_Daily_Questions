// Daily Problem 26th November

class Solution {
    private static int MOD = (int) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        int r=grid.length,c=grid[0].length;
        int[][] prev = new int[c][k];
        int[][] curr = new int[c][k];

        int sum=0;
        for(int j=0;j<c;j++)
        {
            sum=(sum+grid[0][j]) % k;
            prev[j][sum]=1;
        }
        sum = grid[0][0] % k;
        for(int i=1;i<r;i++)
        {
            sum=(sum+grid[i][0])%k;
            Arrays.fill(curr[0],0);
            curr[0][sum]=1;
            for(int j=1;j<c;j++)
            {
                Arrays.fill(curr[j], 0);
                int val=grid[i][j];
                for(int x=0;x<k;x++)
                {
                    int nr=(x+val)%k;
                    curr[j][nr]=(prev[j][x]+curr[j-1][x])%MOD;
                }
            }
            int[][] t=prev;
            prev=curr;
            curr=t;
        }

        return prev[c-1][0];
    }
}