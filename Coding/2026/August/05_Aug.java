// Daily Problem 5th August

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] l=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
           l[i]=new ArrayList<>();
        }
        int[] inDegree=new int[n];
        for(int[] i:invocations)
        {
            l[i[0]].add(i[1]);
            inDegree[i[1]]++;
        }
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(k);
        boolean[] b=new boolean[n];
        b[k]=true;
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int v:l[u])
            {
                inDegree[v]--;
                if(!b[v])
                {
                    q.offer(v);
                    b[v]=true;
                }
            }
        }
        boolean canRemoveAll=true;
        List<Integer> l1=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(b[i] && inDegree[i]>0)
            {
                canRemoveAll=false;
                break;
            }
            else if(!b[i])
            {
                l1.add(i);
            }
        }
        if(!canRemoveAll)
        {
            List<Integer> l2=new ArrayList<>(n);
            for(int i=0;i<n;i++)
            {
                l2.add(i);
            }
            return l2;
        }
        return l1;
    }
}