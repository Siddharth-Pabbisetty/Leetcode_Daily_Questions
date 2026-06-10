// Daily Problem 24th May

class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        dp=new int[n];
        int ans=1;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,solve(i,arr,d));
        }
        return ans;
    }

    private int solve(int i, int[] arr, int d)
    {
        if(dp[i]!=0)
        {
            return dp[i];
        }
        int val=1;
        for(int j=i+1;j<=Math.min(arr.length-1,i+d);j++)
        {
            if(arr[j]>=arr[i])
            {
                break;
            }
            val=Math.max(val,1+solve(j,arr,d));
        }
        for(int j=i-1;j>=Math.max(0,i-d);j--)
        {
            if(arr[j]>=arr[i])
            {
                break;
            }
            val=Math.max(val,1+solve(j,arr,d));
        }
        return dp[i]=val;
    }
}