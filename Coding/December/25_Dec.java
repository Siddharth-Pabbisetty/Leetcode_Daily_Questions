// Daily Problem 25th December

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int cnt=0;
        long ans=0;
        int n=happiness.length;
        for(int i=n-1;i>=n-k;i--)
        {
            if(happiness[i]+cnt>0)
            {
                ans+=(long)(happiness[i]+cnt);
            }
            cnt-=1;
        }
        return ans;
    }
}