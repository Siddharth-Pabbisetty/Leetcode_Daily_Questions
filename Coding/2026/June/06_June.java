// Daily Problem 6th June

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rSum=0;
        for(int i:nums)
        {
            rSum+=i;
        }
        int lSum=0;
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            rSum-=nums[i];
            res[i]=Math.abs(lSum-rSum);
            lSum+=nums[i];
        }
        return res;
    }
}