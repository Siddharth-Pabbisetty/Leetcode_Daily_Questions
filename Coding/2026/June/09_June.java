// Daily Problem 9th June

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mini=nums[0],maxi=nums[0];
        for(int i:nums)
        {
            mini=Math.min(mini,i);
            maxi=Math.max(maxi,i);
        }
        return (long)(maxi-mini)*k;
    }
}