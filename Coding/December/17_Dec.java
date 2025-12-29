// Daily Problem 17th December

class Data{
    long profit=0, buy=0, sell=0;
    Data(long profit, long buy, long sell)
    {
        this.profit=profit;
        this.buy=buy;
        this.sell=sell;
    }
}
class Solution {
    static public long maximumProfit(int[] prices, int k) {
        int p=prices[0], n=prices.length;
        Data [] dp=new Data[k+1];
        for(int i=0;i<=k;i++)
        {
            dp[i]=new Data(0,-p,p);
        }
        for(int i=1; i<n; i++)
        {
            int val=prices[i];
            for(int j=k;j>0;j--)
            {
                Data cur=dp[j];
                long prev=dp[j-1].profit;
                cur.profit=Math.max(cur.profit, Math.max(cur.buy+val, cur.sell-val));
                cur.buy=Math.max(cur.buy,prev-val);
                cur.sell=Math.max(cur.sell,prev+val);
            }
        }
        return dp[k].profit;
    }
}