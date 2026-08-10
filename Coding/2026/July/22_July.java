// Daily Problem 22nd July

class Solution {
    int[] lg;
    class Run {
        int l;
        int r;
        int type;
        int length;
        Run(int l, int r, int type)
        {
            this.l = l;
            this.r = r;
            this.type = type;
            this.length = r - l + 1;
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        ArrayList<Run> segments = new ArrayList<>();
        ArrayList<Run> oneSegs = new ArrayList<>();
        int[] gainToOrigIdx = new int[n + 1];
        int k = 0;
        int idx = 0;
        while (k < n)
        {
            int j = k;
            gainToOrigIdx[k] = idx;
            while(j+1<n && s.charAt(j+1) == s.charAt(k))
            {
                j++;
            }
            segments.add(new Run(k, j, s.charAt(k) - '0'));
            if(s.charAt(k)-'0'==1)
            {
                oneSegs.add(new Run(k, j, s.charAt(k) - '0'));
            }
            k=j+1;
            idx++;
        }
        lg=new int[segments.size()+1];
        int[] gain=new int[segments.size()];
        for(int j=0;j<segments.size();j++)
        {
            if(segments.get(j).type==1)
            {
                if(j-1>=0 && j+1<segments.size())
                {
                    gain[j]=segments.get(j-1).length+segments.get(j+1).length;
                }
            }
        }
        int[][] st = buildSparseTable(segments.size(), gain);
        int activeSession=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='1')
            {
                activeSession++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] i:queries)
        {
            int l=i[0],r=i[1];
            int left=findFirstIdx(oneSegs,l,r);
            int right=findLastIdx(oneSegs,l,r);
            if(left==-1)
            {
                ans.add(activeSession);
                continue;
            }
            int firstSegIdx=gainToOrigIdx[left];
            int lastSegIdx=gainToOrigIdx[right];
            Run leftZeroFirst=segments.get(firstSegIdx-1);
            Run rightZeroFirst=segments.get(firstSegIdx+1);
            int lzFirst=leftZeroFirst.r-Math.max(l,leftZeroFirst.l)+1;
            int rzFirst=Math.min(r,rightZeroFirst.r)-rightZeroFirst.l+1;
            int gainFirst=lzFirst+rzFirst;
            if(left==right)
            {
                ans.add(activeSession+gainFirst);
                continue;
            }
            Run leftZeroLast=segments.get(lastSegIdx-1);
            Run rightZeroLast=segments.get(lastSegIdx+1);
            int lzLast=leftZeroLast.r-Math.max(l,leftZeroLast.l)+1;
            int rzLast=Math.min(r,rightZeroLast.r)-rightZeroLast.l+1;
            int gainLast=lzLast+rzLast;
            int bestGain=Math.max(gainFirst,gainLast);
            if (firstSegIdx+2 <= lastSegIdx-2)
            {
                bestGain=Math.max(bestGain,query(firstSegIdx+2,lastSegIdx-2,st));
            }
            ans.add(activeSession+bestGain);
        }
        return ans;
    }

    private int findFirstIdx(ArrayList<Run> oneSegs, int left, int right) {
        int l=0,h=oneSegs.size()-1;
        int idx=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int start=oneSegs.get(mid).l;
            int end=oneSegs.get(mid).r;
            if(start>left && end<right)
            {
                idx=start;
                h=mid-1;
            }
            else if(start<=left)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return idx;
    }

    private int findLastIdx(ArrayList<Run> oneSegs, int left, int right) {
        int l=0,h=oneSegs.size()-1;
        int idx=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int start=oneSegs.get(mid).l;
            int end=oneSegs.get(mid).r;
            if(start>left && end<right)
            {
                idx=start;
                l=mid+1;
            }
            else if(end>=right)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return idx;
    }

    private int[][] buildSparseTable(int m, int[] gain) {
        int cnt=1;
        while((1<<cnt)<=m)
        {
            cnt++;
        }
        int[][] arr=new int[cnt][m];
        for(int i=0;i<m;i++)
        {
            arr[0][i]=gain[i];
        }
        for(int k=1;k<cnt;k++)
        {
            for(int i=0;i+(1<<k)<=m;i++)
            {
                arr[k][i]=Math.max(arr[k-1][i],arr[k-1][i+(1<<(k-1))]);
            }
        }
        for(int i=2;i<=m;i++)
        {
            lg[i]=lg[i/2]+1;
        }
        return arr;
    }

    private int query(int l, int r, int[][] arr)
    {
        if(l>r)
        {
            return 0;
        }
        int k=lg[r-l+1];
        return Math.max(arr[k][l],arr[k][r-(1<<k)+1]);
    }
}