// Daily Problem 11th June

class Solution {
    static int MOD=1000000007;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<Integer>[] ls=new ArrayList[n+1];
        Arrays.setAll(ls,i->new ArrayList<>());
        for(int[] i:edges)
        {
            ls[i[0]].add(i[1]);
            ls[i[1]].add(i[0]);
        }
        return (int) pow(2,dfs(1,0,ls)-1);
    }

    private int dfs(int node,int prev,List<Integer>[] ls)
    {
        int dist=0;
        for(int i:ls[node])
        {
            if(i!=prev)
            {
                dist=Math.max(dist,dfs(i,node,ls)+1);
            }
        }
        return dist;
    }

    private long pow(long base, int exp)
    {
        long res=1;
        while(exp>0)
        {
            if(exp%2>0)
            {
                res=res*base%MOD;
            }
            base=base*base%MOD;
            exp/=2;
        }
        return res;
    }
}