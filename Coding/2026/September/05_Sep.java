// Daily Problem 5th September

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxi=-1;
        int idx=0,max=0;
        for(int i=0;i<nums.length;i++)
        {
            maxi=Math.max(maxi,nums[i]);
            if(i==idx)
            {
                max=maxi;
            }
            if(nums[i]<max-k)
            {
                idx=i+1;
            }
        }
        return idx<nums.length?idx:-1;
    }
}