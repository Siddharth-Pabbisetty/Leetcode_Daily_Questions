// Daily Problem 6th November
import java.util.*;

class Solution {
    static class DSU {
        int[] powS,st;
        DSU(int n)
        {
            powS=new int[n+1];
            st=new int[n+1];
            for(int i=0;i<=n;i++)
            {
                powS[i]=i;
                st[i]=1;
            }
        }

        int find(int x)
        {
            return powS[x]==x? x : (powS[x]=find(powS[x]));
        }

        void unite(int a, int b)
        {
            a=find(a);
            b=find(b);
            if(a==b)
              return;
            if(st[a] < st[b])
            {
                a=a+b-(b=a);
            }
            powS[b]=a;
            st[a]+=st[b];
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);
        for (int[] i : connections)
            dsu.unite(i[0], i[1]);

        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();
        for(int i=1;i<=c;i++)
        {
            int r=dsu.find(i);
            mp.computeIfAbsent(r, k -> new PriorityQueue<>()).offer(i);
        }

        boolean[] offline = new boolean[c+1];
        List<Integer> res = new ArrayList<>(queries.length);

        for (int[] q : queries)
        {
            int t = q[0], x = q[1];
            if (t == 2)
            {
                offline[x] = true;
            }
            else
            {
                if (!offline[x])
                {
                    res.add(x);
                }
                else
                {
                    int r = dsu.find(x);
                    PriorityQueue<Integer> pq = mp.get(r);
                    if (pq == null)
                    {
                        res.add(-1);
                        continue;
                    }
                    while(!pq.isEmpty() && offline[pq.peek()])
                        pq.poll();
                    res.add(pq.isEmpty() ? -1 : pq.peek());
                }
            }
        }

        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i] = res.get(i);
        return ans;
    }
}