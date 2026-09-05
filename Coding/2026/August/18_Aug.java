// Daily Problem 18th August

class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] arr=new int[51];
        for(int i:nums)
        {
            arr[i]++;
        }
        int res=-1,n=nums.length;
        for(int i=0;i<n;i++) {
            if(k==n || (arr[nums[i]]==1 && (k==1 || i==0 || i==n-1)))
            {
                res=Math.max(res,nums[i]);
            }
        }
        return res;
    }
}