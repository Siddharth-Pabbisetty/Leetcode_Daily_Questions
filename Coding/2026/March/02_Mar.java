// Daily Problem 2nd March

class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int[] zeros=new int[n];
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            for(int j=n-1;j>=0 && grid[i][j]==0;j--)
            {
                cnt++;
            }
            zeros[i]=cnt;
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int r=n-i-1;
            int j=i;
            while(j<n && zeros[j]<r)
            {
                j++;
            }
            if(j==n)
            {
                return -1;
            }
            while(j>i)
            {
                zeros[j]=zeros[j]+zeros[j-1]-(zeros[j-1]=zeros[j]);
                j--;
                ans++;
            }
        }
        return ans;
    }
}