// Daily Problem 3rd September

class Solution {
    public boolean uniformArray(int[] nums1) {
        int mini=nums1[0];
        int odd=0;
        for(int i:nums1)
        {
            mini=Math.min(mini,i);
            odd|=i&1;
        }
        return (mini&1)==odd;
    }
}