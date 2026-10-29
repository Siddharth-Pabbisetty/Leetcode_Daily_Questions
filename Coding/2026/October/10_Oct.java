// Daily Problem 10th October

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] arr=new int[100001];
        long k=(long)k1+k2;
        int sum=0;
        int maxi=0;
        for(int i=0;i<nums1.length;i++)
        {
            int val=Math.abs(nums1[i]-nums2[i]);
            arr[val]++;
            sum+=val;
            maxi=Math.max(maxi,val);
        }
        if(sum<=k)
        {
            return 0;
        }
        for(int i=maxi;i>0&&k>0;i--)
        {
            long cnt=Math.min(k,arr[i]);
            arr[i]-=cnt;
            arr[i-1]+=cnt;
            k-=cnt;
        }
        long ans=0;
        for(int i=0;i<=maxi;i++)
        {
            ans+=(long)i*i*arr[i];
        }
        return ans;
    }
}