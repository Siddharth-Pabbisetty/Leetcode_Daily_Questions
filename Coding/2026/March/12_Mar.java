// Daily Problem 12th March

class Solution {
    private int find(int v, int[] parent)
    {
        if(parent[v]==v)
        {
            return v;
        }
        return parent[v]=find(parent[v], parent);
    }

    private boolean unionSets(int a, int b, int[] parent, int[] size)
    {
        a=find(a,parent);
        b=find(b,parent);
        if(a!=b)
        {
            if(size[a]<size[b])
            {
                a=a+b-(b=a);
            }
            parent[b]=a;
            size[a]+=size[b];
            return true;
        }
        return false;
    }

    public int maxStability(int n, int[][] edges, int k) {
        int[] parent=new int[n];
        int[] size=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            size[i]=1;
        }
        int cnt=n;
        int res=Integer.MAX_VALUE;
        List<int[]> opt=new ArrayList<>();
        for(int[] i:edges)
        {
            if(i[3] == 1)
            {
                if(unionSets(i[0],i[1],parent,size))
                {
                    cnt--;
                    res=Math.min(res,i[2]);
                }
                else
                {
                    return -1;
                }
            }
        }

        if(cnt==1)
        {
            return res;
        }
        for(int[] i:edges)
        {
            if(i[3]==0)
            {
                opt.add(i);
            }
        }
        opt.sort((a, b) -> b[2] - a[2]);
        List<Integer> l = new ArrayList<>();
        for(int[] i:opt)
        {
            if(unionSets(i[0],i[1],parent,size))
            {
                cnt--;
                l.add(i[2]);
                if(cnt==1)
                {
                    break;
                }
            }
        }

        if(cnt>1)
        {
            return -1;
        }
        for(int i=1;i<=k && i<=l.size();i++)
        {
            int idx=l.size()-i;
            l.set(idx, l.get(idx) * 2);
        }

        int minVal=Integer.MAX_VALUE;
        for(int i:l)
        {
            minVal=Math.min(minVal,i);
        }

        return Math.min(res, minVal);
    }
}