//Daily problem of 10th october

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp=new int[energy.length];
        int ans=Integer.MIN_VALUE;
        for(int i=energy.length-1;i>=0;i--)
        {
            if(i+k<energy.length)
                dp[i]=energy[i]+dp[i+k];
            else
                dp[i]=energy[i];
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}