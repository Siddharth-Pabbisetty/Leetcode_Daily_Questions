// Daily Problem 4th June

class Solution {
    static int maxi=100001;
    static int[] dp=new int[maxi],pref=new int[maxi];

    static {
        for(int i=100;i<maxi;i++)
        {
            int r=i%10;
            int m=(i/10)%10;
            int l=(i/100)%10;
            int val=m>Math.max(l,r) || m<Math.min(l,r)?1:0;
            dp[i]=dp[i/10]+val;
            pref[i]=pref[i-1]+dp[i];
        }
    }

    public int totalWaviness(int num1, int num2) {
        return pref[num2]-pref[num1-1];
    }
}
