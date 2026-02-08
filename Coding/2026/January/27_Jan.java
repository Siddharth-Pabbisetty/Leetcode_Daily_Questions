// Daily Problem 27th January

class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<int[]>[] l = new ArrayList[n];
        for (int i = 0; i < n; i++){
            l[i] = new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0],v=edges[i][1],w =edges[i][2];
            l[u].add(new int[]{v,w});
            l[v].add(new int[]{u,2*w});
        }

        final int MOD=1000000007;
        int[] dist = new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i]=MOD;
        }
        dist[0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,0});

        while(!pq.isEmpty())
        {
            int[] cur=pq.poll();
            int d=cur[0], u=cur[1];
            if(u==n-1)
                return d;
            if(d!=dist[u])
                continue;

            for(int i=0;i<l[u].size();i++)
            {
                int[] e=l[u].get(i);
                int v=e[0],w=e[1];
                if(dist[u]+w<dist[v])
                {
                    dist[v]=dist[u]+w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        return -1;
    }
}