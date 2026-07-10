// Daily Problem 21st June

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int MAX_COST=100000;
        int[] freq=new int[MAX_COST+1];
        for(int i:costs)
        {
            freq[i]++;
        }
        int ans=0;
        for (int i=1;i<=MAX_COST;i++)
        {
            if(freq[i]==0)
            {
                continue;
            }
            int canBuy=Math.min(freq[i],coins/i);
            ans+=canBuy;
            coins-=canBuy*i;
        }
        return ans;
    }
}