// Daily Problem 28th November

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i < n; i++)
            l.add(new ArrayList<>());
        for(int[] i : edges)
        {
            l.get(i[0]).add(i[1]);
            l.get(i[1]).add(i[0]);
        }
        int[] ans = new int[1];
        dfs(l,values,0,-1,ans,k);
        return ans[0];
    }

    static int dfs(List<List<Integer>> l, int[] values, int node, int parent, int[] ans, int k) {
        int sum = values[node];
        for(int temp : l.get(node))
        {
            if(temp != parent)
            {
                sum += dfs(l,values,temp,node,ans,k);
            }
        }
        if(sum % k == 0)
            ans[0]++;
        return sum % k;
    }
}