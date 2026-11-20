// Daily Problem 23rd November

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int i:nums)
        {
            int[] curr=dp.clone();
            for(int j:curr)
            {
                int sum=j+i;
                int r=sum%3;
                dp[r]=Math.max(dp[r],sum);
            }
        }
        return dp[0];
    }
}