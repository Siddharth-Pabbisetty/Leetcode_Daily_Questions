// Daily Problem 5th December

class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }
        int lSum=0;
        int cnt=0;
        for(int i=0;i<nums.length-1;i++)
        {
            lSum+=nums[i];
            int rSum=total-lSum;
            if ((lSum%2) == (rSum%2))
            {
                cnt++;
            }
        }
        return cnt;
    }
}