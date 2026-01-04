// Daily Problem 23rd December

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n=events.length;
        int[] arr=new int[n+1];
        for(int i=n-1; i>=0;i--)
        {
            arr[i]=Math.max(arr[i+1],events[i][2]);
        }
        int ans=0;
        for(int[] i:events)
        {
            int val=i[2];
            int l=0,r=n;
            while(l<r)
            {
                int mid=(l+r)/2;
                if(events[mid][0]>i[1])
                {
                    r=mid;
                }
                else
                {
                    l=mid+1;
                }
            }
            if(l<n)
            {
                val+=arr[l];
            }
            ans=Math.max(ans,val);
        }
        return ans;
    }
}