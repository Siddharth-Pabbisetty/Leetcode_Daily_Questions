// Daily Problem 15th August

class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0,n=nums.length;
        boolean b=false;
        for(int i:nums)
        {
            b|=i>0;
            ans^=i;
        }
        if(!b)
        {
            return 0;
        }
        return ans==0?n-1:n;
    }
}