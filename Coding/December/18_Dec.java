// Daily Problem 18th December

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length, l=k/2;
        long [] sum=new long[n+1];
        long modify=0, add=0;
        for(int i=0; i<n; i++)
        {
            int x=prices[i];
            sum[i+1]=add+=strategy[i]*x;
            modify+=((i>=l & i<k)?x:0);
        }
        long profit=Math.max(sum[n], modify+sum[n]-sum[k]);

        for(int i=1; i+k<=n; i++)
        {
            modify+=prices[i+k-1]-prices[i+l-1];
            profit=Math.max(profit, modify+sum[n]-sum[i+k]+sum[i]);
        }
        return profit;
    }
}