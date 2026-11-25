// Daily Problem 6th November

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        Integer[] arr=new Integer[queries.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(queries[a],queries[b]));
        int[] cnt=new int[n+1];
        int[] ans=new int[arr.length];
        int l=0;
        int r=0;
        int active=0;
        for(int i:arr)
        {
            int t=queries[i];
            while(r<logs.length && logs[r][1]<=t)
            {
                if(++cnt[logs[r++][0]]==1)
                {
                    active++;
                }
            }
            while(l<r && logs[l][1]<t-x)
            {
                if(--cnt[logs[l++][0]]==0)
                {
                    active--;
                }
            }
            ans[i]=n-active;
        }
        return ans;
    }
}