// Daily Problem 23rd September

class Solution {
    public int minOperations(int[] nums, int x) {
        int negX=-x;
        int n=nums.length;
        for(int i:nums)
        {
            negX+=i;
        }
        if(negX<0)
        {
            return -1;
        }
        if(negX==0)
        {
            return n;
        }
        int mini=-1,i=0,sum=0;
        for(int j=0;j<n;j++)
        {
            sum+=nums[j];
            while(sum>negX)
            {
                sum-=nums[i++];
            }
            if(sum==negX)
            {
                mini=Math.max(mini,j-i+1);
            }
        }
        return mini<0?-1:n-mini;
    }
}