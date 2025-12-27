// Daily Problem 15th December

class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=1,cnt=1;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i]==prices[i+1]+1)
                cnt++;
            else
                cnt=1;
            ans+=cnt;
        }
        return ans;
    }
}