// Daily Problem 28th April

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int size=n*m;
        int[] freq=new int[10001];
        int min=grid[0][0],maxi=mini;
        for (int[] row : grid)
        {
            for (int val : row)
            {
                if((val-grid[0][0]) % x != 0)
                {
                    return -1;
                }
                freq[val]++;
                mini=Math.min(mini, val);
                maxi=Math.max(maxi, val);
            }
        }

        int target=(size+1)/2;
        int acc=0,median=mini;
        for(int i=mini;i<=maxi;i+=x)
        {
            acc+=freq[i];
            if(acc>=target)
            {
                median=i;
                break;
            }
        }
        int ops = 0;
        for(int i=mini;i<=maxi;i+=x)
        {
            ops+=Math.abs(i-median)/x*freq[i];
        }
        return ops;
    }
}