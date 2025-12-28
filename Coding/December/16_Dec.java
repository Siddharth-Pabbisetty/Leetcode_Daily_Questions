// Daily Problem 16th December

class Solution {
    List<Integer>[] tree;
    int[] buyPrice, sellPrice;
    int budget;
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        buyPrice = present;
        sellPrice = future;
        this.budget = budget;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for (int[] i:hierarchy)
        {
            int a = i[0] - 1;
            int b  = i[1] - 1;
            tree[a].add(b);
        }
        int[][] dp = dfs(0);
        return dp[budget][0];
    }

    public int[][] dfs(int u)
    {
        int[][] dp = new int[budget + 1][2];
        for(int i:tree[u])
        {
            int[][] child = dfs(i);
            int[][] next = new int[budget+1][2];

            for(int j=0;j<=budget;j++)
            {
                for(int k=0;k<=j;k++)
                {
                    next[j][0] = Math.max(next[j][0], dp[j-k][0]+child[k][0]);
                    next[j][1] = Math.max(next[j][1], dp[j-k][1] + child[k][1]);
                }
            }
            dp = next;
        }

        int[][] ans = new int[budget + 1][2];

        for(int i=0;i<=budget;i++)
        {
            ans[i][0]=dp[i][0];
            if(i>=buyPrice[u])
            {
                ans[i][0] = Math.max(ans[i][0], sellPrice[u]-buyPrice[u] + dp[i-buyPrice[u]][1]);
            }

            int discounted = buyPrice[u] / 2;
            ans[i][1] = dp[i][0];
            if(i>=discounted)
            {
                ans[i][1]=Math.max(ans[i][1], sellPrice[u] - discounted + dp[i-discounted][1]);
            }
        }
        return ans;
    }
}