// Daily Problem 1st August

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        if((n&1)==0)
        {
            return true;
        }
        int[][] dp=new int[n][n];
        for(int[] i:dp)
        {
            Arrays.fill(i,-1);
        }
        return solve(0,n-1,nums,dp) >= 0;
    }

    private int solve(int i,int j,int[] nums,int[][] dp)
    {
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(i==j)
        {
            return dp[i][j]=nums[i];
        }
        return dp[i][j]=Math.max(nums[i]-solve(i+1,j,nums,dp), nums[j]-solve(i,j-1,nums,dp));
    }
}