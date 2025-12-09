// Daily Problem 27th November

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long n=nums.length, MOD=Long.MAX_VALUE/2;
        long [] arr=new long[k];
        for(int i=0;i<k-1;i++)
            arr[i]=MOD;
        arr[k-1]=0;
        long prefix=0,ans=-MOD;
        for(int i=0;i<n;i++)
        {
            prefix+=nums[i];
            int j=i%k;
            ans=Math.max(ans, prefix-arr[j]);
            arr[j]=Math.min(prefix,arr[j]);
        }
        return ans;
    }
}